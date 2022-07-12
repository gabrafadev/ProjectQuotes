package pe.idat.projectmvvm.data.network


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.idat.projectmvvm.core.RetrofitHelper
import pe.idat.projectmvvm.data.model.QuoteModel
import javax.inject.Inject


class QuoteService @Inject constructor(private val api:QuoteApiClient){


    suspend fun getQuotes():List<QuoteModel> {
        return withContext(Dispatchers.IO) {
        val response = api.getAllQuotes()
        response.body() ?: emptyList()
    }
    }
}