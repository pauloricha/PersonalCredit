package com.pan.pancashbackloan.ui.start

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pan.pancashbackloan.R
import com.pan.pancashbackloan.databinding.StartFragmentBinding

class StartFragment : Fragment() {

    private var _binding: StartFragmentBinding? = null
    private val binding: StartFragmentBinding get() = _binding!!

    private lateinit var viewModel: StartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requireActivity().window.statusBarColor = getResources().getColor(R.color.dark_gray)
            requireActivity().window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }

        _binding = StartFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(StartViewModel::class.java)

        binding.imageInfoItem1.setOnClickListener {
            findNavController().navigate(
                R.id.action_start_to_confirmation
            )
        }

        binding.imageInfoItem2.setOnClickListener {
            findNavController().navigate(
                R.id.action_start_to_simulation
            )
        }
    }
}