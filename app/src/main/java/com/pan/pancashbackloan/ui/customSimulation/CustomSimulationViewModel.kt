package com.pan.pancashbackloan.ui.customSimulation

import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import java.util.*

class CustomSimulationViewModel : ViewModel() {

    fun getPercentageValue(progressValue: String) : Double{
        val percentageValue = progressValue.toDouble() * 0.08
        return percentageValue
    }

    fun getFormatMoney(valueToFormat: Double): String {
        val format = NumberFormat.getCurrencyInstance(Locale( "pt", "BR" ))
        return format.format(valueToFormat).toString()
    }
}