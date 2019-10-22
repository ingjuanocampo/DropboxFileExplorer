package juanocampo.test.presentation.model

import juanocampo.test.domain.status.UserStatus

interface LoginModel {

    suspend fun doLogin(): Boolean

    suspend fun processLogin(): UserStatus

}