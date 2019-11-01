import base.implementation
import base.projectImplementation
import dependencies.Dependencies
import dependencies.coroutinesWithAndroid
import dependencies.daggerWithAndroid
import dependencies.testAndroidDependencies
import org.gradle.api.artifacts.dsl.DependencyHandler

private fun DependencyHandler.appProjects() {
    projectImplementation(":domain")
    projectImplementation(":data")
    projectImplementation(":presentation")
    projectImplementation(":cache")
    projectImplementation(":remote")
}

fun DependencyHandler.appDependencies() {
    appProjects()
    daggerWithAndroid()
    coroutinesWithAndroid()
    implementation(Dependencies.picasso)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.kotlinStdlib)
    implementation(Dependencies.constraitLayout)
    implementation(Dependencies.recyclerView)
    testAndroidDependencies()
}