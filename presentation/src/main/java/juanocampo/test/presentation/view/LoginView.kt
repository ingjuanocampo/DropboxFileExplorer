package juanocampo.test.presentation.view

interface LoginView {
    fun loginSuccess(welcomeMsn: String)
    fun loginInProgress()
    fun notLoggedUser()
    fun generalError()
}