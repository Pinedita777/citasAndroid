package com.example.examplemvvm.data.repositories

import com.example.examplemvvm.data.model.DataResponse
import com.example.examplemvvm.data.model.LoginDTO
import com.example.examplemvvm.data.model.UserModel
import com.example.examplemvvm.data.network.LoginService
import com.example.examplemvvm.provider.UserProvider

class LoginRepository {
    private val loginService = LoginService()
    suspend fun login(loginDTO: LoginDTO): DataResponse<UserModel> {
        val response = loginService.login(loginDTO)
        if (response.status == "success") {
            UserProvider.user = response.data
        }
        return response
    }
}