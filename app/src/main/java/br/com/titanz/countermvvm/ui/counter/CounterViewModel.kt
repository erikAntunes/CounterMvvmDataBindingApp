package br.com.titanz.countermvvm.ui.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private var number = 1

    // Expondo Variavel para View
    private val _counter = MutableLiveData<String>()
    val counter: LiveData<String>
        get() = _counter

    // Iniciando valores da ViewModel
    init {
        _counter.value = getNumberRepository()
    }

    //TODO IMPLEMENTAR CHAMADA ASYNC DO REPOSITÓRIO
    fun getNumberRepository(): String {

        return number.toString()
    }

    // Aplicando Regra de Negocio
    fun clickMe() {
        _counter.value = (++number).toString()
    }
}