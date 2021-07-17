package br.com.titanz.countermvvm.ui.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.com.titanz.countermvvm.R
import br.com.titanz.countermvvm.databinding.FragmentCouterBinding

class CounterFragment : Fragment() {
    companion object {
        fun newInstance() = CounterFragment()
    }

    // Instanciando ViewModel
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_couter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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