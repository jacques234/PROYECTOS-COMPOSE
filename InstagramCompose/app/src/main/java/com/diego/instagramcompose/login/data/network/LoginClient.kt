package com.diego.instagramcompose.login.data.network

import com.diego.instagramcompose.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("/v3/8fe748b9-e996-4594-aa12-3a035842dd68")
    suspend fun doLogin():Response<LoginResponse>
}