import org.gradle.kotlin.dsl.kotlin

plugins {
    id("com.android.library")
    kotlin ("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion (28)


    defaultConfig {
        minSdkVersion (21)
        targetSdkVersion (28)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

}

dependencies {

    val daggerVersion = "2.24"

    // Dagger 2
    implementation ("com.google.dagger:dagger:$daggerVersion")
    annotationProcessor ("com.google.dagger:dagger-compiler:$daggerVersion")
    kapt ("com.google.dagger:dagger-compiler:$daggerVersion")

    implementation(project(":data"))

    implementation ("com.dropbox.core:dropbox-core-sdk:3.1.1")
    implementation ("com.squareup.picasso:picasso:2.71828")

    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.50")
    implementation ("androidx.appcompat:appcompat:1.1.0")
    implementation ("androidx.core:core-ktx:1.1.0")
    testImplementation ("junit:junit:4.12")
    androidTestImplementation ("androidx.test:runner:1.1.1")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.1.1")
}
