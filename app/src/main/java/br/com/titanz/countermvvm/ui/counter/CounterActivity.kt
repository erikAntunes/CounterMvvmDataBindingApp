package br.com.titanz.countermvvm.ui.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.titanz.countermvvm.R

class CounterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        navigateToFragmentCouter(savedInstanceState)
    }

    private fun navigateToFragmentCouter(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.couter_container, CounterFragment.newInstance())
                .commitNow()
        }
    }
}