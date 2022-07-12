package pe.idat.projectmvvm.data.network


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.idat.projectmvvm.core.RetrofitHelper
import pe.idat.projectmvvm.data.model.QuoteModel



class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<QuoteModel> {
        return withContext(Dispatchers.IO) {
        val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
        response.body() ?: emptyList()
    }
    }
}