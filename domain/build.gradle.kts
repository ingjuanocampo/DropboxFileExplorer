import org.gradle.kotlin.dsl.kotlin

plugins {
    id("kotlin")
    kotlin("kapt")
}


dependencies {

    val daggerVersion = "2.24"

    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.50")

    // Dagger 2
    implementation ("com.google.dagger:dagger:$daggerVersion")
    annotationProcessor ("com.google.dagger:dagger-compiler:$daggerVersion")
    kapt ("com.google.dagger:dagger-compiler:$daggerVersion")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}
