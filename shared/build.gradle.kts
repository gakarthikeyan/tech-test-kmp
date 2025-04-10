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
                    jvmTarget.set(JvmTarget.JVM_17)
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
            implementation(libs.koin.core)

            // Coroutines for async tasks
            implementation(libs.kotlinx.coroutines.core)

            // Network call
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.kotlinx.serialization.json)

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {

            implementation(libs.ktor.client.okhttp)
        }
        iosMain.dependencies {

//            implementation(libs.ktor.client.okhttp)
        }
        nativeMain.dependencies {
//            implementation(libs.ktor.client.okhttp)
        }
    }
}

android {
    namespace = "com.karthik.android.techtestkmp"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    flavorDimensions += "env"
    productFlavors {
        create("QA1"){
            dimension = "env"
            buildConfigField("String", "BASE_URL", "\"https://www.dbooks.org\"")
            buildConfigField("String", "HOST", "\"www.dbooks.org\"")
        }

        create("QA2"){
            dimension = "env"
            buildConfigField("String", "BASE_URL", "\"https://www.dbooks.org\"")
            buildConfigField("String", "HOST", "\"www.dbooks.org\"")
        }

    }
}