package br.com.titanz.countermvvm.ui.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.titanz.countermvvm.repository.counter.CounterModel
import br.com.titanz.countermvvm.repository.counter.CounterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CounterViewModel(
    private val counterRepository: CounterRepository
) : ViewModel() {
    private var adcCounter = 1
    private var resetCounter = 1
    private var saveCounter = 1

    // Criando e Expondo LiveData para View
    private val _clickCounter = MutableLiveData<String>()
    val clickCounter: LiveData<String>
        get() = _clickCounter

    // Iniciando Contador no Init da ViewModel
    init {
        _clickCounter.value = adcCounter.toString()
    }

    // Adicionando valor ao Contador
    fun clickAdd() {
        _clickCounter.value = (++adcCounter).toString()
        saveCounter = adcCounter
    }

    // Resetando Contador
    fun clickReset() {
        _clickCounter.value = resetCounter.toString()
        adcCounter = resetCounter
        saveCounter = resetCounter
    }

    // Salvando Valor do Contador no Repositório
    fun saveCounterNumber() {
        Thread.sleep(1000)
        counterRepository.saveCounterNumber(saveCounter)
    }

    // Chamando Lista de Objetos Contador do Repositório
    fun getCounterCoroutines() {
        CoroutineScope(Dispatchers.Main).launch {
            val counters = withContext(Dispatchers.Default) {
                counterRepository.getCounterCoroutines()
            }
            setCounterView(counters)
        }
    }

    // Setando valor do Contador em Cache no Repositório
    private fun setCounterView(counters: List<CounterModel>) {
        Thread.sleep(2000)
        _clickCounter.value = counters[0].totalCounter.toString()
        adcCounter = counters[0].totalCounter
    }

    // Factory para Injetar Repositório na ViewModel
    class CouterViewModelFactory(
        private val counterRepository: CounterRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CounterViewModel(counterRepository) as T
        }
    }
}
