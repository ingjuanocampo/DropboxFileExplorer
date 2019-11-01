import base.implementation
import base.projectImplementation
import dependencies.Dependencies
import dependencies.coroutinesWithAndroid
import dependencies.daggerWithAndroid
import dependencies.testAndroidDependencies
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.appProjects() {
    projectImplementation(":domain")
    projectImplementation(":data")
    projectImplementation(":presentation")
    projectImplementation(":cache")
    projectImplementation(":remote")
}

fun DependencyHandler.appDependencies() {
    daggerWithAndroid()
    coroutinesWithAndroid()
    implementation(Dependencies.picasso)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.kotlinStdlib)
    implementation(Dependencies.constraitLayout)
    implementation(Dependencies.recyclerView)
    testAndroidDependencies()
}