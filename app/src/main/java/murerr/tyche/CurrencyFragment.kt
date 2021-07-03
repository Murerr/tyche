package murerr.tyche

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import murerr.tyche.databinding.FragmentCurrencyBinding
import murerr.tyche.viewmodels.CurrencyViewModel


class CurrencyFragment : Fragment() {

    private lateinit var binding: FragmentCurrencyBinding

    private val viewModel: CurrencyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyBinding.inflate(inflater, container, false)
        return binding.root
    }
    
}
