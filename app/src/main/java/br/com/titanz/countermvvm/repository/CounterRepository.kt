package br.com.titanz.countermvvm.repository

class CounterRepository {
    // TODO REFATORAR COM COROUTINES
    fun getCounter(callback: (counters: List<CounterModel>) -> Unit) {
        Thread(Runnable {
            Thread.sleep(1000)
            callback.invoke(
                listOf(
                    CounterModel(
                        300
                    )
                )
            )
        }).start()
    }
    //TODO CRIAR FUNÇÃO QUE ARMAZENA NUMERO DE CLICKS NO REPOSITÓRIO
    fun setCounter(){
    }
}