package com.example.examplemvvm.domain

import com.example.examplemvvm.data.model.DataResponse
import com.example.examplemvvm.data.model.LoginDTO
import com.example.examplemvvm.data.model.UserModel
import com.example.examplemvvm.data.repositories.LoginRepository

class PostLoginUseCase {
    private val loginRepository = LoginRepository()
    suspend operator fun invoke(loginDTO: LoginDTO): DataResponse<UserModel>{
        return loginRepository.login(loginDTO)
    }
}