package murerr.tyche

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import murerr.tyche.databinding.FragmentSpeedBinding
import murerr.tyche.viewmodels.SpeedViewModel


class SpeedFragment : Fragment() {

    private lateinit var binding: FragmentSpeedBinding

    private val viewModel: SpeedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpeedBinding.inflate(inflater, container, false)
        return binding.root
    }
    
}
