package dependencies

import base.*
import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {

    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"

    const val dagger = "com.google.dagger:dagger:$daggerVersion"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:$daggerVersion"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:$daggerVersion"

    const val picasso = "com.squareup.picasso:picasso:$picassoVersion"

    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:$androidXVersion"
    const val androidCore = "androidx.core:core-ktx:$androidXVersion"
    const val constraitLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
    const val recyclerView = "androidx.recyclerview:recyclerview:$recyclerViewXVersion"
}

object Android {
    const val compileAndroidSdkVersion = ANDROID_Q
    const val minAndroidSdkVersion = ANDROID_LOLLIPOP
}


object TestDependecies {
    const val junit = "junit:junit:$junitVersion"
    const val androidTest = "androidx.test:runner:$androidRunnerVersion"
    const val espresso = "androidx.test.espresso:espresso-core:$androidEspresso"

}


fun DependencyHandler.dagger() {
    implementation(Dependencies.dagger)
    kotlinImplementation(Dependencies.daggerCompiler)
}

fun DependencyHandler.coroutines() {
    implementation(Dependencies.coroutineCore)
}

fun DependencyHandler.coroutinesWithAndroid() {
    coroutines()
    implementation(Dependencies.coroutineAndroid)
}

fun DependencyHandler.daggerWithAndroid() {
    dagger()
    implementation(Dependencies.daggerAndroidSupport)
    kotlinImplementation(Dependencies.daggerAndroidProcessor)
}

fun DependencyHandler.testDependencies() {
    testImplementation(TestDependecies.junit)
}

fun DependencyHandler.testAndroidDependencies() {
    testDependencies()
    androidTestImplementation(TestDependecies.androidTest)
    androidTestImplementation(TestDependecies.espresso)
}







