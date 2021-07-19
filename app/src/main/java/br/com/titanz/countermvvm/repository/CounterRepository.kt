package br.com.titanz.countermvvm.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CounterRepository {

    private var totalCounter = 1

    suspend fun getCounterCoroutines(): List<CounterModel> {
        return withContext(Dispatchers.Default) {
            listOf(
                CounterModel(
                    totalCounter
                )
            )
        }
    }

    fun saveCounterNumber(counter: Int) {
        totalCounter = counter
    }
}