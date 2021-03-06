package com.pan.pancashbackloan.ui.receipt

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pan.pancashbackloan.R
import com.pan.pancashbackloan.databinding.ReceiptFragmentBinding

class ReceiptFragment : Fragment() {

    private var _binding: ReceiptFragmentBinding? = null
    private val binding: ReceiptFragmentBinding get() = _binding!!

    private lateinit var viewModel: ReceiptViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ReceiptFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requireActivity().window.statusBarColor = getResources().getColor(R.color.light_white)
            requireActivity().window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        viewModel = ViewModelProvider(this).get(ReceiptViewModel::class.java)
    }
}