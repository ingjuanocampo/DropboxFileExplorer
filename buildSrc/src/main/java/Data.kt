import base.kotlinImplementation
import base.projectImplementation
import dependencies.Dependencies
import dependencies.coroutines
import dependencies.dagger
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.dataDependencies() {
    projectImplementation(domain)
    kotlinImplementation(Dependencies.kotlinStdlib)
    coroutines()
    dagger()
}