import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "2.0.0"
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            // Kotlin Standard Library
            implementation(kotlin("stdlib"))

            // Koin for Dependency Injection (Works in KMP)
            implementation("io.insert-koin:koin-core:3.5.0")

            // Coroutines for async tasks
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

            // Network call
            implementation("io.ktor:ktor-client-core:2.3.9")
            implementation("io.ktor:ktor-client-content-negotiation:2.3.9")
            implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.9")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            // No-OP
            implementation("io.ktor:ktor-client-okhttp:2.3.9")
        }
        iosMain.dependencies {
            //NO-OP
            implementation("io.ktor:ktor-client-okhttp:2.3.9")
        }
        nativeMain.dependencies {
            implementation("io.ktor:ktor-client-okhttp:2.3.9")
        }
    }
}

android {
    namespace = "com.karthik.android.techtestkmp"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}