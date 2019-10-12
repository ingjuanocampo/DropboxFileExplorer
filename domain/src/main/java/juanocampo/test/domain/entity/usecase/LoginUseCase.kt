package juanocampo.test.domain.entity.usecase

import juanocampo.test.domain.entity.repository.UserRepository
import java.lang.Exception

class LoginUseCase(private val userRepository: UserRepository) {

    operator fun invoke(): Boolean {
        return try {
            userRepository.login()
            true
        } catch (e: Exception) {
            false
        }
    }
}