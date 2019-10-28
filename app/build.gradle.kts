import org.gradle.kotlin.dsl.kotlin

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")

}


android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "juanocampo.test.dropboxexplorer"
        minSdkVersion(21)
        targetSdkVersion(29)
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

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":presentation"))
    implementation(project(":cache"))
    implementation(project(":remote"))

    val daggerVersion = "2.24"
    val kotlinCoroutineVersion = "1.0.1"

    //coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutineVersion")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutineVersion")

    // Dagger 2
    implementation ("com.google.dagger:dagger:$daggerVersion")
    kapt ("com.google.dagger:dagger-compiler:$daggerVersion")
    implementation ("com.google.dagger:dagger-android-support:$daggerVersion")
    kapt ("com.google.dagger:dagger-android-processor:$daggerVersion")

    implementation ("com.squareup.picasso:picasso:2.71828")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.50")
    implementation ("androidx.appcompat:appcompat:1.0.2")
    implementation ("androidx.core:core-ktx:1.0.2")
    implementation ("androidx.constraintlayout:constraintlayout:1.1.3")
    testImplementation("junit:junit:4.12")
    androidTestImplementation ("androidx.test:runner:1.1.1")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.1.1")
    implementation("androidx.recyclerview:recyclerview:1.0.0")
}


