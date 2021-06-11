package com.pan.pancashbackloan.ui.confirmation

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
import com.pan.pancashbackloan.databinding.ConfirmationFragmentBinding
import com.pan.pancashbackloan.ui.start.StartFragmentArgs

//@AndroidEntryPoint
class ConfirmationFragment : Fragment() {

    private lateinit var binding: ConfirmationFragmentBinding

    private val viewModel: ConfirmationViewModel by viewModels()

    val args: ConfirmationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requireActivity().window.statusBarColor = getResources().getColor(R.color.dodger_blue)
        }

        binding = ConfirmationFragmentBinding.inflate(inflater, container, false)

        binding.tvSimulatedValue.setTextLabel(getMoneyFormat(args.money.toDouble()))

        binding.btnToSuccess.setOnClickListener {
            findNavController().navigate(
                R.id.action_confirmation_to_success
            )
        }

        return binding.root
    }
}