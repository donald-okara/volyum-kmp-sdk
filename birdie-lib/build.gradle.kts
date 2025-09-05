import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.kotlin.serialization)
    id("com.codingfeline.buildkonfig") version "0.17.1"
}


buildkonfig {
    packageName = "ke.don.birdie_lib"

    defaultConfigs {
        buildConfigField(STRING, "SUPABASE_URL", providers.gradleProperty("SUPABASE_URL").get())
        buildConfigField(STRING, "SUPABASE_ANON_KEY", providers.gradleProperty("SUPABASE_ANON_KEY").get())
    }
}

kotlin {

    androidLibrary {
        namespace = "ke.don.birdie_lib"
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

    val xcfName = "birdie-libKit"

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
