import org.gradle.kotlin.dsl.kotlin
import dependencies.Android.compileAndroidSdkVersion
import dependencies.Android.minAndroidSdkVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(compileAndroidSdkVersion)
    defaultConfig {
        applicationId = "juanocampo.test.dropboxexplorer"
        minSdkVersion(minAndroidSdkVersion)
        targetSdkVersion(compileAndroidSdkVersion)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    appDependencies()
}


