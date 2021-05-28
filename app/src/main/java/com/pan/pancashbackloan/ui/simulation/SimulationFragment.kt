package com.pan.pancashbackloan.ui.simulation

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

    private var _binding: SimulationFragmentBinding? = null
    private val binding: SimulationFragmentBinding get() = _binding!!

    private val viewModel: SimulationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SimulationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.simulatedValues.observe(viewLifecycleOwner, Observer<SimulatedValues> {
            simulatedValues ->
            binding.txtInstallment.setTextLabel(simulatedValues.installment)
            binding.txtMoney.setTextLabel(simulatedValues.money)
        })

        binding.slider.apply {
            setOnPanSliderListener(object: IPanSliderListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean,
                                               progressValue: String) {
                    viewModel.getSimulatedValues(progressValue.toDouble())
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
    }
}