import org.gradle.kotlin.dsl.kotlin

plugins {
    kotlin("kapt")
    id("kotlin")
}


dependencies {
    cacheDependencies()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}
