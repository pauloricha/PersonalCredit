package com.pan.pancashbackloan.ui.customSimulation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pan.dskit.editText.PanEditText.IPanEditTextListener
import com.pan.pancashbackloan.R
import com.pan.pancashbackloan.databinding.CustomSimulationFragmentBinding

//@AndroidEntryPoint
class CustomSimulationFragment : Fragment() {

    private var _binding: CustomSimulationFragmentBinding? = null
    private val binding: CustomSimulationFragmentBinding get() = _binding!!

    private lateinit var viewModel: CustomSimulationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getActivity()?.getWindow()?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        _binding = CustomSimulationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CustomSimulationViewModel::class.java)

        binding.edText.setOnPanEditTextListener(object: IPanEditTextListener {
            override fun onValueToSimulate(valueToSimulate: String) {
                binding.txtInstallments.setTextLabel(viewModel.getFormatMoney(
                    viewModel.getPercentageValue(valueToSimulate)))
            }
        })

        binding.btnToPaymentMonth.setOnClickListener {
            findNavController().navigate(
                R.id.action_custom_simulation_to_payment_month
            )
        }
    }
}