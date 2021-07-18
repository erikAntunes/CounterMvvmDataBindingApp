package br.com.titanz.countermvvm.ui.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.titanz.countermvvm.repository.CounterRepository

class CounterViewModel(
    private val counterRepository: CounterRepository
) : ViewModel() {
    private var adcNumber = 1
    private var totalCounter: String? = null

    // Expondo Variavel do Contador para View
    private val _clickCounter = MutableLiveData<String>()
    val clickCounter: LiveData<String>
        get() = _clickCounter

    // Iniciando valores da ViewModel
    init {
        _clickCounter.value = adcNumber.toString()
    }

    // Chamada de Variavel do Banco de Dados
    fun getCounterLiveData(){
        counterRepository.getCounter {
            totalCounter = it[0].totalCounter.toString()
        }
        Thread.sleep(2000)
        setCounter()
    }

    // Setando a variavel do Contador com Valor do Repositório
    fun setCounter(){
        _clickCounter.value = totalCounter.toString()
    }

    // Aplicando Regra de Negocio ao Clickar
    fun clickMe() {
        _clickCounter.value = (++adcNumber).toString()
    }

    // Factory para Injetar Repositório na ViewModel
    class CouterViewModelFactory(
        private val counterRepository: CounterRepository
    ) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
           return CounterViewModel(counterRepository) as T
        }
    }
}