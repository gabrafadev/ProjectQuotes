package pe.idat.projectmvvm.ui.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.idat.projectmvvm.data.model.QuoteModel
import pe.idat.projectmvvm.data.model.QuoteProvider
import pe.idat.projectmvvm.domain.GetQuotesUseCase
import pe.idat.projectmvvm.domain.GetRandomQuoteUseCase
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase :GetQuotesUseCase,
    private val getRandomQuoteUseCase :GetRandomQuoteUseCase
): ViewModel(){

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

//    var getQuotesUseCase = GetQuotesUseCase()
//    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch{
            isLoading.postValue(true)
            val result =getQuotesUseCase()

            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[10])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote(){
        //val currentQuote = QuoteProvider.random()
        //quoteModel.postValue(currentQuote)
        isLoading.postValue(true)
        val quote= getRandomQuoteUseCase()
        if (quote!=null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }

}