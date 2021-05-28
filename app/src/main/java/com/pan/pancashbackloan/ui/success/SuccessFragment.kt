package com.pan.pancashbackloan.ui.success

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pan.pancashbackloan.R
import com.pan.pancashbackloan.databinding.SuccessFragmentBinding

//@AndroidEntryPoint
class SuccessFragment : Fragment() {

    private var _binding: SuccessFragmentBinding? = null
    private val binding: SuccessFragmentBinding get() = _binding!!

    private lateinit var viewModel: SuccessViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requireActivity().window.statusBarColor = getResources().getColor(R.color.dark_gray)
            requireActivity().window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }

        _binding = SuccessFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SuccessViewModel::class.java)

        val anim: Animation = ScaleAnimation(
                0.0F, 1.0F,
                0.0F, 1.0F,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1f)
        anim.fillAfter = true
        anim.duration = 1200
        binding.imgOval.startAnimation(anim)

        binding.btnOpenReceipt.setOnClickListener {
            findNavController().navigate(
                R.id.action_success_to_receipt
            )
        }
    }
}