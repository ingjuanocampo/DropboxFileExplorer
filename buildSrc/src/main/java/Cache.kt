import base.implementation
import base.projectImplementation
import dependencies.Dependencies.kotlinStdlib
import dependencies.dagger
import org.gradle.api.artifacts.dsl.DependencyHandler


fun DependencyHandler.cacheDependencies() {
    projectImplementation(":data")
    dagger()
    implementation(kotlinStdlib)
}