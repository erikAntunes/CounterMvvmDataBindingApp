package br.com.titanz.countermvvm.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CounterRepository {

    private var totalCounterCache = 1

    suspend fun getCounterCoroutines(): List<CounterModel> {
        return withContext(Dispatchers.Default) {
            listOf(
                CounterModel(
                    totalCounterCache
                )
            )
        }
    }

    fun saveCounterNumber(counter: Int) {
        totalCounterCache = counter
    }
}