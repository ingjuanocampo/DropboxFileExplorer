package juanocampo.test.presentation.model

import juanocampo.test.domain.status.UserStatus
import juanocampo.test.domain.usecase.LoadUserInformationUseCase
import juanocampo.test.domain.usecase.LoginUseCase

class LoginModelImpl(private val loginUseCase: LoginUseCase,
                     private val loadUserInformationUseCase: LoadUserInformationUseCase): LoginModel {

    override suspend fun doLogin() = loginUseCase()

    override suspend fun processLogin(): UserStatus = loadUserInformationUseCase()

}