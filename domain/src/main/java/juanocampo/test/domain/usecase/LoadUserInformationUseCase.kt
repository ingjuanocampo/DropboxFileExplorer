package juanocampo.test.domain.usecase

import juanocampo.test.domain.repository.UserRepository
import juanocampo.test.domain.status.UserError
import juanocampo.test.domain.status.UserNotLogged
import juanocampo.test.domain.status.UserStatus
import juanocampo.test.domain.status.UserAuthenticated
import java.lang.Exception

class LoadUserInformationUseCase(private val userRepository: UserRepository) {

    operator fun invoke(): UserStatus {
        return try {
            val userInformation = userRepository.loadUser()
            if (userInformation != null) {
                UserAuthenticated(userInformation)
            } else {
                UserNotLogged
            }
        } catch (e: Exception) {
            UserError
        }
    }
}