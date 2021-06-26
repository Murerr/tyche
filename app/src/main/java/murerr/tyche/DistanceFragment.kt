package murerr.tyche

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import murerr.tyche.databinding.FragmentDistanceBinding
import murerr.tyche.viewmodels.DistanceViewModel

class DistanceFragment : Fragment() {

    private lateinit var binding: FragmentDistanceBinding

    private val viewModel: DistanceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDistanceBinding.inflate(inflater, container, false)
        return binding.root
    }

}