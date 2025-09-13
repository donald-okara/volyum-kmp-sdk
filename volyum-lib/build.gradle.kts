import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin.serialization)
    id("org.jetbrains.dokka") version "2.0.0"
    id("org.jetbrains.kotlinx.atomicfu") version "0.29.0"
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
    namespace = "ke.don.volyum.feedback"
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
