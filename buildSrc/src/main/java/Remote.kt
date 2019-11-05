import base.implementation
import base.projectImplementation
import dependencies.Dependencies
import dependencies.dagger
import dependencies.testAndroidDependencies
import dependencies.testDependencies
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.remoteDependencies() {
    projectImplementation(data)
    dagger()
    implementation ("com.dropbox.core:dropbox-core-sdk:3.1.1")
    implementation(Dependencies.picasso)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.androidCore)
    testDependencies()
    testAndroidDependencies()
}