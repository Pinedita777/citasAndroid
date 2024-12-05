package com.example.examplemvvm.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplemvvm.data.model.LoginDTO
import com.example.examplemvvm.data.model.UserModel
import com.example.examplemvvm.domain.PostLoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    val userModel = MutableLiveData<UserModel>()
    val message = MutableLiveData<String?>()
    val isLoading = MutableLiveData<Boolean>()

    val postLoginUseCase = PostLoginUseCase()

    fun onCreate(loginDTO: LoginDTO) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val response = postLoginUseCase(loginDTO)


            when (response.status) {
                "success" -> {
                    userModel.postValue(response.data)
                    isLoading.postValue(false)
                }

                "error" -> {
                    if (response.message != null) {
                        message.postValue(response.message)
                        isLoading.postValue(false)
                    }
                }

                "invalid" -> {
                    message.postValue(response.message)
                    isLoading.postValue(false)
                }

                else -> {
                    message.postValue("error con el servidor")
                    isLoading.postValue(false)
                }
            }
        }
    }

}