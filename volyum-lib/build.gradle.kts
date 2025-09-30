import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin.serialization)
    id("org.jetbrains.dokka") version "2.0.0"
    id("com.vanniktech.maven.publish") version "0.34.0"
    id("org.jetbrains.kotlinx.atomicfu") version "0.29.0"
}

group = "io.github.donald-okara"
version = project.findProperty("version") ?: throw GradleException("Version property is required. Pass it with -Pversion=<version>")

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

kotlin {

    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    val xcfName = "Volyum-feedbackKit"

    iosX64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosSimulatorArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kermit)
                implementation(libs.kotlin.stdlib)
                implementation(libs.bundles.ktor)
                implementation(libs.kotlinx.datetime)
                implementation(libs.kotlinx.atomicfu)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.kotlinx.coroutines.test)
            }
        }

        jvmMain {
            dependencies {
                implementation(libs.ktor.client.okhttp)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.ktor.client.okhttp)
            }
        }

        iosMain {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}

android {
    namespace = "io.github.donald_okara.volyum"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = 24
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

mavenPublishing {
    publishToMavenCentral() // or publishToMavenCentral(automaticRelease = true)
    signAllPublications()

    coordinates(group as String, "volyum", version as String)

    pom {
        name.set("Volyum SDK")
        description.set("The SDK for the Volyum feedback platform.")
        inceptionYear.set("2025")
        url.set("https://github.com/donald-okara/volyum-kmp-sdk/")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("repo")
            }
        }
        developers {
            developer {
                id.set("donald-okara")
                name.set("Donald Okara")
                url.set("https://github.com/donald-okara/")
            }
        }
        scm {
            url.set("https://github.com/donald-okara/volyum-kmp-sdk/")
            connection.set("scm:git:git://github.com/donald-okara/volyum-kmp-sdk.git")
            developerConnection.set("scm:git:ssh://git@github.com/donald-okara/volyum-kmp-sdk.git")
        }
    }
}
