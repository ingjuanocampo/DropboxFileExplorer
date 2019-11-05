import base.implementation
import base.projectImplementation
import dependencies.Dependencies
import dependencies.coroutinesWithAndroid
import dependencies.daggerWithAndroid
import dependencies.testAndroidDependencies
import org.gradle.api.artifacts.dsl.DependencyHandler

const val domain = ":domain"
const val data = ":data"
const val presentation = ":presentation"
const val cache = ":cache"
const val remote = ":remote"


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


private fun DependencyHandler.appProjects() {
    projectImplementation(domain)
    projectImplementation(data)
    projectImplementation(presentation)
    projectImplementation(cache)
    projectImplementation(remote)
}