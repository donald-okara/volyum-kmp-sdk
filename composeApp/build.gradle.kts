import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import org.gradle.kotlin.dsl.named
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
    alias(libs.plugins.kotlin.serialization)
    id("com.codingfeline.buildkonfig") version "0.17.1"
    id("org.jetbrains.dokka") version "2.0.0"
}

// Configure Dokka GFM
tasks.named<DokkaTask>("dokkaGfm").configure {
    moduleName.set("Volyum sdk")

    dokkaSourceSets.configureEach {
        suppress.set(false)
        skipEmptyPackages.set(true)
    }
}

// Copy to /docs-md for README embedding
tasks.register<Copy>("publishMarkdownDocs") {
    dependsOn("dokkaGfm")
    from(layout.buildDirectory.dir("dokka/gfm"))
    into(rootProject.layout.projectDirectory.dir("docs-md").dir(project.name))
}
val keysFile = rootProject.file("local.properties")
val keys = Properties()
if (keysFile.exists()) {
    keys.load(keysFile.inputStream())
}

buildkonfig {
    packageName = "ke.don.volyum.demo"

    defaultConfigs {
        buildConfigField(STRING, "VOLYUM_PROJECT_ID", "${keys["VOLYUM_PROJECT_ID"]}")
        buildConfigField(STRING, "VOLYUM_API_KEY", "${keys["VOLYUM_API_KEY"]}")
    }
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    jvm()

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.ktor.client.okhttp)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.koffee)
            implementation(compose.materialIconsExtended)
            implementation(libs.bundles.coil)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(project(":volyum-lib"))
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
            implementation(libs.ktor.client.okhttp)
        }
        iosMain {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}

android {
    namespace = "ke.don.volyum.demo"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "ke.don.volyum.demo"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "ke.don.volyum.demo.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ke.don.volyum.demo"
            packageVersion = "1.0.0"
        }
    }
}
