package com.appwork.mvvmloginmodule.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.appwork.mvvmloginmodule.R
import com.appwork.mvvmloginmodule.databinding.ActivityLoginBinding
import com.appwork.mvvmloginmodule.utils.hide
import com.appwork.mvvmloginmodule.utils.show
import com.appwork.mvvmloginmodule.utils.showToast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.edit_text_email
import kotlinx.android.synthetic.main.activity_login.edit_text_password
import kotlinx.android.synthetic.main.activity_login.progress_bar
import kotlinx.android.synthetic.main.activity_sign_up.*

class LoginActivity : AppCompatActivity(), LoginAuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginBinding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        loginBinding.viewModelLogin = loginViewModel
        loginViewModel.authListener = this
    }

    override fun onStartAuth() {
       progress_bar.show()
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this,
        Observer {
            progress_bar.hide()
            showToast(it)
            edit_text_email.text.clear()
            edit_text_password.text.clear()
        })
    }

    override fun onFinished() {
        showToast("Finished")
    }

    override fun onError(errorMessage: String) {
        showToast(errorMessage)
    }
}