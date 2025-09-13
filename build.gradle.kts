import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.kotlin.dsl.configure

plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeHotReload) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.androidKotlinMultiplatformLibrary) apply false
    id("com.diffplug.spotless") version "7.2.1"
}

subprojects {
    apply(plugin = "com.diffplug.spotless")
    configure<SpotlessExtension> {
        kotlin {
            target("**/*.kt")
            targetExclude("${layout.buildDirectory.get().asFile}/**/*.kt")
            ktlint("0.50.0")
                .editorConfigOverride(
                    mapOf(
                        "ktlint_standard_package-name" to "disabled",
                        "ktlint_standard_no-wildcard-imports" to "disabled"
                    )
                )
            licenseHeaderFile(rootProject.file("spotless/copyright.kt"))
        }

        kotlinGradle {
            target("*.gradle.kts")
            ktlint("0.50.0")
        }
    }
}

tasks.register("publishMarkdownDocsAll") {
    group = "documentation"
    description = "Run publishMarkdownDocs across subprojects (if present) and regenerate README links."

    // collect actual publishMarkdownDocs tasks from subprojects (safe: ignores subprojects without the task)
    val publishTasks = subprojects.flatMap { sub ->
        sub.tasks.matching { it.name == "publishMarkdownDocs" }.toList()
    }

    if (publishTasks.isNotEmpty()) dependsOn(publishTasks)
}
