package com.example.examplemvvm.data.network

import com.example.examplemvvm.core.RetrofitHelper
import com.example.examplemvvm.data.model.DataResponse
import com.example.examplemvvm.data.model.LoginDTO
import com.example.examplemvvm.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {
    private val retrofitTwo = RetrofitHelper.getRetrofitTwo()
    suspend fun login(loginDTO: LoginDTO): DataResponse<UserModel>{
        return withContext(Dispatchers.IO){
            //Llamada al api
            val response = retrofitTwo.create(LoginApiClient::class.java).login(loginDTO)
            response.body() ?:
            DataResponse(UserModel("",""), "error","error")
        }
    }
}