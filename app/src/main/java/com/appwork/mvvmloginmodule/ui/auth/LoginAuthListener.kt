package com.appwork.mvvmloginmodule.ui.auth

import androidx.lifecycle.LiveData

interface LoginAuthListener {
    public fun onStartAuth()
    public fun onSuccess(loginResponse: LiveData<String>)
    public fun onFinished()
    public fun onError(errorMessage:String)

}