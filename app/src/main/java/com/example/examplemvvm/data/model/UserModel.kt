package com.example.examplemvvm.data.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("name") val name: String,
    @SerializedName("last_name") val lastname: String

)
