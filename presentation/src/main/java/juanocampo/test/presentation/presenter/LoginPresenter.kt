package juanocampo.test.presentation.presenter

import juanocampo.test.presentation.model.LoginModel
import juanocampo.test.presentation.view.LoginView
import kotlinx.coroutines.launch

class LoginPresenter(private val loginModel: LoginModel): BasePresenter<LoginView>() {

    fun attemptLogin() = launch {
        val isLoginSent = loginModel.doLogin()
        if (isLoginSent) publishResults{ view?.loginInProgress() }
    }

    fun processLogin() = launch {
        val isAuthenticated = loginModel.processLogin()
        if (isAuthenticated) publishResults{ view?.loginSuccess() }
    }

}