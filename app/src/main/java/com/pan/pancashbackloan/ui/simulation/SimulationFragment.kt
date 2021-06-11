package com.pan.pancashbackloan.ui.simulation

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.pan.dskit.seekbar.PanSlider.IPanSliderListener
import com.pan.pancashbackloan.R
import com.pan.pancashbackloan.databinding.SimulationFragmentBinding
import com.pan.pancashbackloan.model.SimulatedValues

class SimulationFragment : Fragment() {

    private lateinit var binding: SimulationFragmentBinding

    private val viewModel: SimulationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requireActivity().window.statusBarColor = getResources().getColor(R.color.light_white)
            requireActivity().window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        binding = SimulationFragmentBinding.inflate(inflater, container, false)

        binding.slider.apply {
            setOnPanSliderListener(object: IPanSliderListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean,
                                               progressValue: String) {
                    viewModel.getSimulatedValues(progressValue.toInt())
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                }
            })
        }

        binding.btnContinue.setOnClickListener {
            findNavController().navigate(
                R.id.action_simulation_to_payment_month
            )
        }

        binding.btnToCustomSimulation.setOnClickListener {
            findNavController().navigate(
                R.id.action_simulation_to_custom_simulation
            )
        }

        subscribeUi()

        return binding.root
    }

    private fun subscribeUi() {
        viewModel.simulatedValues.observe(viewLifecycleOwner, Observer<SimulatedValues> {
                simulatedValues ->
            binding.txtInstallment.setTextLabel(simulatedValues.installment)
            binding.txtMoney.setTextLabel(simulatedValues.money)
        })
    }
}