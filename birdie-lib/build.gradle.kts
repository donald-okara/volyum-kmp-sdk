import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.kotlin.serialization)
    id("com.codingfeline.buildkonfig") version "0.17.1"
}

val keysFile = rootProject.file("local.properties")
val keys = Properties()
if (keysFile.exists()) {
    keys.load(keysFile.inputStream())
}

buildkonfig {
    packageName = "ke.don.birdie.feedback"

    defaultConfigs {
        buildConfigField(STRING, "SUPABASE_URL", "${keys["SUPABASE_URL"]}")
        buildConfigField(STRING, "SUPABASE_ANON_KEY", "${keys["SUPABASE_ANON_KEY"]}")
    }
}

kotlin {

    androidLibrary {
        namespace = "ke.don.birdie.feedback"
        compileSdk = 36
        minSdk = 26

        withHostTestBuilder {
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    val xcfName = "birdie-feedbackKit"

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
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
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

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.runner)
                implementation(libs.androidx.core)
                implementation(libs.androidx.testExt.junit)
            }
        }

        iosMain {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}
