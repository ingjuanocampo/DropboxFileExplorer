import org.gradle.kotlin.dsl.kotlin

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(Config.Android.compileSdkVersion)
    defaultConfig {
        applicationId = "juanocampo.test.dropboxexplorer"
        minSdkVersion(21)
        targetSdkVersion(Config.Android.compileSdkVersion)
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
    appProjects()
    appDependencies()
}


