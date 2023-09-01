package com.carbon.survey.ui.vote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.carbon.survey.R
import com.carbon.survey.databinding.FragmentVoteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class VoteFragment : Fragment() {

    private lateinit var binding: FragmentVoteBinding
    private val viewModel: VoteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentVoteBinding.inflate(inflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.voteAction.setOnClickListener {
            viewModel.vote(binding.voteSlider.value)
            findNavController().navigate(R.id.action_voteFragment_to_statsFragment)
        }
        binding.voteRemoveAllInfo.setOnClickListener {
            viewModel.removeAllUserdata()
        }

        viewModel.textEvent.observe(viewLifecycleOwner, ::displayText)
    }

    private fun displayText(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        viewModel.trackVoteOpened()
    }
}