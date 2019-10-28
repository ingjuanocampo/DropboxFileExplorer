import org.gradle.kotlin.dsl.kotlin


plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
}


android {
    compileSdkVersion (29)


    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion (29)
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

    implementation(project(":domain"))

    val daggerVersion = "2.24"
    val kotlinCoroutineVersion = "1.0.1"

    //coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutineVersion")
    implementation( "org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutineVersion")

    // Dagger 2
    implementation ("com.google.dagger:dagger:$daggerVersion")
    annotationProcessor ("com.google.dagger:dagger-compiler:$daggerVersion")
    kapt ("com.google.dagger:dagger-compiler:$daggerVersion")

    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.50")
    implementation ("androidx.appcompat:appcompat:1.0.2")
    implementation ("androidx.core:core-ktx:1.0.2")
    testImplementation ("junit:junit:4.12")
    androidTestImplementation ("androidx.test:runner:1.1.1")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.1.1")
}
