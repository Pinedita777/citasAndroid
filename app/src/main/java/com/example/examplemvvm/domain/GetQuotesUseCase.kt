package com.example.examplemvvm.domain

import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.data.repositories.QuoteRepository

class GetQuotesUseCase {
    private val quoteRepository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>?{
        return quoteRepository.getAllQuotes()
    }

}