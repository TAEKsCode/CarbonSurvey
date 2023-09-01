package com.carbon.survey.ui.stats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.carbon.survey.databinding.FragmentStatsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class StatsFragment() : Fragment() {

    private lateinit var binding: FragmentStatsBinding
    private val viewModel: StatsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentStatsBinding.inflate(inflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.stats.observe(viewLifecycleOwner) {
            binding.stats = it
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.trackResultsOpened()
    }
}