package com.pan.pancashbackloan.common

import com.pan.pancashbackloan.model.SimulatedValues
import java.text.NumberFormat
import java.util.*

class DataFormatter {

    fun getSimulatedValues(progressValue: Double) : SimulatedValues{
        val percentageValue = progressValue.toInt() * 0.08
        return SimulatedValues(getMoneyFormat(progressValue), getMoneyFormat(percentageValue))
    }

    fun getMoneyFormat(valueToFormat: Double): String {
        val format = NumberFormat.getCurrencyInstance(Locale( "pt", "BR" ))
        return format.format(valueToFormat).toString()
    }
}