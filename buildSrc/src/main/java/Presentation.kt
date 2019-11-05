import base.implementation
import base.projectImplementation
import dependencies.*
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.presentationDependencies() {
    projectImplementation(domain)
    coroutinesWithAndroid()
    daggerWithAndroid()
    implementation(Dependencies.kotlinStdlib)
    testDependencies()
    testAndroidDependencies()
}