package pe.idat.projectmvvm.data

import pe.idat.projectmvvm.data.model.QuoteModel
import pe.idat.projectmvvm.data.model.QuoteProvider
import pe.idat.projectmvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api : QuoteService,
    private val quoteProvider: QuoteProvider
) {

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}