package juanocampo.test.dropboxexplorer.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import juanocampo.test.dropboxexplorer.R
import juanocampo.test.presentation.presenter.LoginPresenter
import juanocampo.test.presentation.view.LoginView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class LoginActivity: AppCompatActivity(), LoginView {

    @Inject
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginButton.setOnClickListener {
            presenter.attemptLogin()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.bind(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unBind()
    }

    override fun loginSuccess(welcomeMsn: String) {
        Toast.makeText(this, welcomeMsn, Toast.LENGTH_LONG).show()
        progressBar.visibility = View.GONE
        loginButton.visibility = View.GONE
        val intent = FileExplorerActivity.Factory.build(this)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun loginInProgress() {
        progressBar.visibility = View.VISIBLE
        loginButton.visibility = View.GONE
    }

    override fun notLoggedUser() {
        progressBar.visibility = View.GONE
        loginButton.visibility = View.VISIBLE
    }

    override fun generalError() {
        notLoggedUser()
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
    }
}