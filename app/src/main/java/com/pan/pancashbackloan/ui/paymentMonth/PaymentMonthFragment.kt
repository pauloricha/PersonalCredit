package com.pan.pancashbackloan.ui.paymentMonth

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pan.pancashbackloan.R
import com.pan.pancashbackloan.databinding.PaymentMonthFragmentBinding

//@AndroidEntryPoint
class PaymentMonthFragment : Fragment() {

    private var _binding: PaymentMonthFragmentBinding? = null
    private val binding: PaymentMonthFragmentBinding get() = _binding!!

    private lateinit var viewModel: PaymentMonthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PaymentMonthFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PaymentMonthViewModel::class.java)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requireActivity().window.statusBarColor = getResources().getColor(R.color.light_white)
            requireActivity().window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        binding.btnToConfirmation.setOnClickListener {
            findNavController().navigate(
                R.id.action_payment_month_to_confirmation
            )
        }
    }
}