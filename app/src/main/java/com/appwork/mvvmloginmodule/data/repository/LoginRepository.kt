package com.appwork.mvvmloginmodule.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.appwork.mvvmloginmodule.data.network.ApiRequests
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {
    fun loginUser(
        email: String,
        password: String
    ): LiveData<String> {
        val loginResponse = MutableLiveData<String>()
        ApiRequests().loginRequest(email, password)
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful) {
                        loginResponse.value = response.body()?.string()
                    } else {
                        loginResponse.value = response.errorBody()?.string()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginResponse.value = t.message
                }

            })
        return loginResponse
    }
}