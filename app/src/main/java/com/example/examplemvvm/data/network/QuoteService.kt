package com.example.examplemvvm.data.network

import com.example.examplemvvm.core.RetrofitHelper
import com.example.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class QuoteService {
    private val retrofit:Retrofit = RetrofitHelper.getRetrofitHelper()

    suspend fun getQuotes(): List<QuoteModel>
     {  //cambio a hilo secundario para la llamada api
        return withContext(Dispatchers.IO) {
            //llamada a la api

            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}