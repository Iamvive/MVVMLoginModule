package com.appwork.mvvmloginmodule.data.network

import com.appwork.mvvmloginmodule.utils.NetworkUtils
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiRequests {
    @FormUrlEncoded
    @POST(NetworkUtils.NetworkUrls.LOGIN)
    fun loginRequest(
        @Field("email") email: String,
        @Field("password") password: String
    ):Call<ResponseBody>

    companion object{
        operator fun invoke():ApiRequests{
            return Retrofit.Builder()
                .baseUrl(NetworkUtils.BASE_URL)
                .build()
                .create(ApiRequests::class.java)
        }
    }
}