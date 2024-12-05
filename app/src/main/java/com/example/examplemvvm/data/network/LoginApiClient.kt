package com.example.examplemvvm.data.network

import com.example.examplemvvm.data.model.DataResponse
import com.example.examplemvvm.data.model.LoginDTO
import com.example.examplemvvm.data.model.UserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiClient {
    @POST("sign_in")
    suspend fun login(
        @Body loginDTO: LoginDTO
    ): Response<DataResponse<UserModel>>
}