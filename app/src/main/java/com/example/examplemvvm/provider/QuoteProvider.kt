package com.example.examplemvvm.provider

import com.example.examplemvvm.data.model.QuoteModel

class QuoteProvider {
    companion object {

      var quotes: List<QuoteModel> = emptyList()
    }
}