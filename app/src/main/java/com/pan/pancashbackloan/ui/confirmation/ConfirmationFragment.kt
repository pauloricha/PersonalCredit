package com.pan.pancashbackloan.ui.confirmation

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pan.pancashbackloan.R
import com.pan.pancashbackloan.databinding.ConfirmationFragmentBinding

//@AndroidEntryPoint
class ConfirmationFragment : Fragment() {

    private var _binding: ConfirmationFragmentBinding? = null
    private val binding: ConfirmationFragmentBinding get() = _binding!!

    private lateinit var viewModel: ConfirmationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ConfirmationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requireActivity().window.statusBarColor = getResources().getColor(R.color.dodger_blue)
        }

        viewModel = ViewModelProvider(this).get(ConfirmationViewModel::class.java)

        binding.btnContinue.setOnClickListener {
            findNavController().navigate(
                R.id.action_confirmation_to_success
            )
        }
    }
}