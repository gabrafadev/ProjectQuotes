package pe.idat.projectmvvm.domain

import pe.idat.projectmvvm.data.QuoteRepository
import pe.idat.projectmvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository : QuoteRepository
){

    suspend operator fun invoke() = repository.getAllQuotes()

}