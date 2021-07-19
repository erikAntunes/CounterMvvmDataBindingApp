package br.com.titanz.countermvvm.ui.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import br.com.titanz.countermvvm.R
import br.com.titanz.countermvvm.databinding.FragmentCouterBinding
import br.com.titanz.countermvvm.repository.counter.CounterRepository

class CounterFragment : androidx.fragment.app.Fragment() {
    companion object {
        fun newInstance() = CounterFragment()
    }

    // Criando Counter ViewModel
    private lateinit var viewModel: CounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_couter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Setup ViewModel Factory
        viewModel = ViewModelProvider(
            this,
            CounterViewModel.CouterViewModelFactory(CounterRepository())
        ).get(CounterViewModel::class.java)

        // Setup DataBinding
        val binding: FragmentCouterBinding = DataBindingUtil.setContentView(
            requireActivity(),
            R.layout.fragment_couter
        )
        // Setup ViewModel e LifyCycle
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }
}