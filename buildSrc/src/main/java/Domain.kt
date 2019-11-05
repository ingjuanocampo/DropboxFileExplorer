import base.implementation
import dependencies.Dependencies
import dependencies.dagger
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.domainDependencies() {
    dagger()
    implementation(Dependencies.kotlinStdlib)
}