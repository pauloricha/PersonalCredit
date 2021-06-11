package com.pan.pancashbackloan.ui.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.pan.pancashbackloan.R
import com.pan.pancashbackloan.common.getMoneyFormat
import com.pan.pancashbackloan.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requireActivity().window.statusBarColor = getResources().getColor(R.color.dodger_blue)
        }

        binding = HomeFragmentBinding.inflate(inflater, container, false)

        binding.btnSimulate.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeToStart(viewModel.getLoadApproved())
            findNavController().navigate(action)
        }

        subscribeUi()

        return binding.root
    }

    private fun subscribeUi() {
        viewModel.loanApproved.observe(viewLifecycleOwner, Observer<Int> {
                loanApproved ->
            binding.tvLoanAproved.setTextLabel(getMoneyFormat(loanApproved.toDouble()))
        })
        viewModel.getLoanApproved()
    }
}