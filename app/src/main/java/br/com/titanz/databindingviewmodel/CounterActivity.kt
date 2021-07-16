package br.com.titanz.databindingviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import br.com.titanz.databindingviewmodel.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity() {

    private val viewModel: CouterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup DataBinding
        val binding: ActivityCounterBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_counter
        )

        // Setup ViewModel e LifyCycle
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }
}