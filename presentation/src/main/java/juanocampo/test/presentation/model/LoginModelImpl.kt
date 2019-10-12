package juanocampo.test.presentation.model

import juanocampo.test.domain.entity.status.UserStatus
import juanocampo.test.domain.entity.usecase.LoadUserInformationUseCase
import juanocampo.test.domain.entity.usecase.LoginUseCase

class LoginModelImpl(private val loginUseCase: LoginUseCase,
                     private val loadUserInformationUseCase: LoadUserInformationUseCase): LoginModel {

    override suspend fun doLogin() = loginUseCase()

    override suspend fun processLogin(): UserStatus = loadUserInformationUseCase()

}