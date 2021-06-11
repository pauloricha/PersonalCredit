package com.pan.pancashbackloan.ui.start

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.pan.pancashbackloan.R
import com.pan.pancashbackloan.common.getMoneyFormat
import com.pan.pancashbackloan.databinding.StartFragmentBinding

class StartFragment : Fragment() {

    private lateinit var binding: StartFragmentBinding

    private val viewModel: StartViewModel by viewModels()

    val args: StartFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requireActivity().window.statusBarColor = getResources().getColor(R.color.dark_gray)
            requireActivity().window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }

        binding = StartFragmentBinding.inflate(inflater, container, false)

        binding.tvSimulatedValue.setTextLabel(getMoneyFormat(args.money.toDouble()))
        binding.itemSimulateProceed.setTextItem(
            getString(R.string.txt_item_simulate_proceed, getMoneyFormat(args.money.toDouble())))

        binding.itemSimulateProceed.setOnClickListener {
            val action = StartFragmentDirections.actionStartToConfirmation(args.money)
            findNavController().navigate(action)
        }

        binding.imageInfoItem2.setOnClickListener {
            findNavController().navigate(
                R.id.action_start_to_simulation
            )
        }

        binding.imageInfoItem3.setOnClickListener {
            findNavController().navigate(
                R.id.action_start_to_home
            )
        }

        return binding.root
    }
}