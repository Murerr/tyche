package murerr.tyche

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import murerr.tyche.databinding.FragmentTemperatureBinding
import murerr.tyche.viewmodels.TemperatureViewModel


class TemperatureFragment : Fragment() {

    private lateinit var binding: FragmentTemperatureBinding

    private val viewModel: TemperatureViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTemperatureBinding.inflate(inflater, container, false)
        return binding.root
    }
    
}
