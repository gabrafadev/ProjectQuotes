package pe.idat.projectmvvm.domain

import pe.idat.projectmvvm.data.QuoteRepository
import pe.idat.projectmvvm.data.model.QuoteModel
import pe.idat.projectmvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    private val repository= QuoteRepository()

    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber= (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}