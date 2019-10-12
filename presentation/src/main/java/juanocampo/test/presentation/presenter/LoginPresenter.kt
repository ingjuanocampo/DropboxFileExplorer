package juanocampo.test.presentation.presenter

import juanocampo.test.domain.entity.status.UserAuthenticated
import juanocampo.test.domain.entity.status.UserError
import juanocampo.test.domain.entity.status.UserNotLogged
import juanocampo.test.presentation.model.LoginModel
import juanocampo.test.presentation.view.LoginView
import kotlinx.coroutines.launch

class LoginPresenter(private val loginModel: LoginModel) : BasePresenter<LoginView>() {

    fun attemptLogin() = launch {
        val isLoginSent = loginModel.doLogin()
        if (isLoginSent) publishResults { view?.loginInProgress() } else { publishResults { view?.generalError() }}
    }

    override fun bind(view: LoginView) {
        super.bind(view)
        processLogin()
    }

    private fun processLogin() = launch {
        when (val status = loginModel.processLogin()) {
            is UserAuthenticated -> publishResults { view?.loginSuccess("welcome ¡¡ ${status.user.name}") }
            is UserNotLogged -> publishResults { view?.notLoggedUser() }
            is UserError -> publishResults {
                view?.notLoggedUser()
                view?.generalError()
            }

        }
    }

}