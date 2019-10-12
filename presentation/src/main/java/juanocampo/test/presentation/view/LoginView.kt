package juanocampo.test.presentation.view

interface LoginView {
    fun loginSuccess(name: String)
    fun loginInProgress()
    fun notLoggedUser()
    fun generalError()
}