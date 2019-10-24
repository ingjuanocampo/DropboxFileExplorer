import org.gradle.kotlin.dsl.kotlin


plugins {
    id("kotlin")
    kotlin("kapt")

}

dependencies {


    val daggerVersion = "2.24"
    val kotlinCoroutineVersion = "1.0.1"

    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.50")


    implementation(project(":domain"))

    //coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutineVersion")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutineVersion")

    // Dagger 2
    implementation ("com.google.dagger:dagger:$daggerVersion")
    annotationProcessor ("com.google.dagger:dagger-compiler:$daggerVersion")
    kapt ("com.google.dagger:dagger-compiler:$daggerVersion")

}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}
