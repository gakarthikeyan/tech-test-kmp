import java.util.Properties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.karthik.android.techtestkmp.android"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.karthik.android.techtestkmp.android"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
        buildConfig = true
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    flavorDimensions += "env"
    productFlavors {
        create("QA1"){
            dimension = "env"
            applicationIdSuffix = ".qa1"
            versionNameSuffix = "-qa1"
            resValue("string", "app_name", "QA1 Books")
        }

        create("QA2"){
            dimension = "env"
            applicationIdSuffix = ".qa2"
            versionNameSuffix = "-qa2"
            resValue("string", "app_name", "QA2 Books")
        }

    }

    signingConfigs {
        val envPropsFile = rootProject.file("androidApp/environment.properties")
        val envProps = Properties().apply {
            if (envPropsFile.exists()) {
                load(envPropsFile.inputStream())
            }
        }

        create("release") {
            storeFile = file("keystore/release.keystore.jks")
            storePassword = envProps["RELEASE_STORE_PASSWORD"] as String
            keyAlias = envProps["RELEASE_KEY_ALIAS"] as String
            keyPassword = envProps["RELEASE_KEY_PASSWORD"] as String
        }
    }

    buildTypes{
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
        }
        getByName("release") {
            resValue("string", "app_name", "Books")
            isDebuggable = false
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }
    }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.coil.compose)
//    implementation("io.insert-koin:koin-bom:3.5.4")
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
}