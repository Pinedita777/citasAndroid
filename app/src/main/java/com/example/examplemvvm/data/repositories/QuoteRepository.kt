package com.example.examplemvvm.data.repositories

import com.example.examplemvvm.provider.QuoteProvider
import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.data.network.QuoteService

class QuoteRepository {
    private val quoteService = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = quoteService.getQuotes()
        QuoteProvider.quotes = response
        return response
   }
}