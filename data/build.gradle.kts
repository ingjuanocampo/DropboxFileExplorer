import org.gradle.kotlin.dsl.kotlin


plugins {
    id("kotlin")
    kotlin("kapt")

}

dependencies {
    dataDependencies()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}
