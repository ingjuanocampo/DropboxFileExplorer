package juanocampo.test.presentation.model

import juanocampo.test.domain.entity.status.UserStatus

interface LoginModel {

    suspend fun doLogin(): Boolean

    suspend fun processLogin(): UserStatus

}