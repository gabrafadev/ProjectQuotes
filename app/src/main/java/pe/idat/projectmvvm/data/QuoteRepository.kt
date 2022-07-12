package pe.idat.projectmvvm.data

import pe.idat.projectmvvm.data.model.QuoteModel
import pe.idat.projectmvvm.data.model.QuoteProvider
import pe.idat.projectmvvm.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}