package juanocampo.test.presentation.model

interface LoginModel {

    suspend fun doLogin(): Boolean

    suspend fun processLogin(): Boolean

}