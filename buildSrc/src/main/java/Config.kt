import Config.Dependencies.daggerAndroidProcessor
import Config.Dependencies.daggerAndroidSupport
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

private const val androidGradleVersion = "3.5.1"
private const val kotlinVersion = "1.3.50"

// Compile dependencies
private const val androidXVersion = "1.0.2"
private const val daggerVersion = "2.24"
private const val coroutinesVersion = "1.0.1"
private const val recyclerViewXVersion = "1.0.0"
private const val constraintLayoutVersion = "1.1.3"
private const val picassoVersion = "2.71828"

// Unit tests
private const val mockitoVersion = "2.13.0"
private const val junitVersion = "4.12"
private const val androidRunnerVersion = "1.1.1"
private const val androidEspresso = "3.1.1"

object Config {

    object Android {
        const val compileSdkVersion = 29
    }

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
        const val constraitLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
        const val recyclerView = "androidx.recyclerview:recyclerview:$recyclerViewXVersion"


    }

    object TestDependecies {
        const val junit = "junit:junit:$junitVersion"
        const val androidTest = "androidx.test:runner:$androidRunnerVersion"
        const val espresso = "androidx.test.espresso:espresso-core:$androidEspresso"

    }
}


fun DependencyHandler.appProjects() {
    add("implementation", project(":domain"))
    add("implementation", project(":data"))
    add("implementation", project(":presentation"))
    add("implementation", project(":cache"))
    add("implementation", project(":remote"))

}

fun DependencyHandler.appDependencies() {
    daggerWithAndroid()
    coroutinesWithAndroid()
    implementation(Config.Dependencies.picasso)
    implementation(Config.Dependencies.appCompat)
    implementation(Config.Dependencies.kotlinStdlib)
    implementation(Config.Dependencies.constraitLayout)
    implementation(Config.Dependencies.recyclerView)
    testAndroidDependencies()
}

fun DependencyHandler.dagger() {
    implementation(Config.Dependencies.dagger)
    kotlinImplementation(Config.Dependencies.daggerCompiler)
}

fun DependencyHandler.coroutines() {
    implementation(Config.Dependencies.coroutineCore)
}

fun DependencyHandler.coroutinesWithAndroid() {
    coroutines()
    implementation(Config.Dependencies.coroutineAndroid)
}

fun DependencyHandler.daggerWithAndroid() {
    dagger()
    implementation(daggerAndroidSupport)
    kotlinImplementation(daggerAndroidProcessor)
}

fun DependencyHandler.testDependencies() {
    testImplementation(Config.TestDependecies.junit)
}

fun DependencyHandler.testAndroidDependencies() {
    testDependencies()
    androidTestImplementation(Config.TestDependecies.androidTest)
    androidTestImplementation(Config.TestDependecies.espresso)
}


fun DependencyHandler.implementation(dependency: String): Dependency? =
    add("implementation", dependency)

fun DependencyHandler.kotlinImplementation(dependency: Any): Dependency? =
    add("kapt", dependency)

fun DependencyHandler.testImplementation(dependencyNotation: String): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.androidTestImplementation(dependencyNotation: String): Dependency? =
    add("androidTestImplementation", dependencyNotation)






