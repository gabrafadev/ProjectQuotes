package pe.idat.projectmvvm.domain

import pe.idat.projectmvvm.data.QuoteRepository
import pe.idat.projectmvvm.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>?
    = repository.getAllQuotes()


}