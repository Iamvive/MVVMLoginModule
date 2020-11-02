package com.appwork.mvvmloginmodule.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.appwork.mvvmloginmodule.data.repository.LoginRepository

class LoginViewModel : ViewModel() {
    var email: String? = null
    var password: String? = null
    public var authListener: LoginAuthListener? = null

   public fun authUser(view:View) {
       authListener?.onStartAuth()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            //Error
            authListener?.onError("PLease fill the values.")
            return
        }
        //Success
       val loginResponse=LoginRepository().loginUser(email!!,password!!)
       authListener?.onSuccess(loginResponse)
    }

}