package com.example.examplemvvm.domain

import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.data.repositories.QuoteRepository
import com.example.examplemvvm.provider.QuoteProvider

class GetRandomQuoteUseCase {
    private val repository = QuoteRepository()

    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber: Int = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}