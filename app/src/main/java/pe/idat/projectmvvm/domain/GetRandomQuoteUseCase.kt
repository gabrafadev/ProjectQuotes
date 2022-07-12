package pe.idat.projectmvvm.domain

import pe.idat.projectmvvm.data.QuoteRepository
import pe.idat.projectmvvm.data.model.QuoteModel
import pe.idat.projectmvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {


    operator fun invoke(): QuoteModel?{
        val quotes = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber= (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}