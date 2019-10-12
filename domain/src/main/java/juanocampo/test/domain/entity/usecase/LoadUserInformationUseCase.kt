package juanocampo.test.domain.entity.usecase

import juanocampo.test.domain.entity.repository.UserRepository
import juanocampo.test.domain.entity.status.UserError
import juanocampo.test.domain.entity.status.UserNotLogged
import juanocampo.test.domain.entity.status.UserStatus
import juanocampo.test.domain.entity.status.UserAuthenticated
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