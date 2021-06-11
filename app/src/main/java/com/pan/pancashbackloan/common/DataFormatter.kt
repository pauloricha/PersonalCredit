package com.pan.pancashbackloan.common

import com.pan.pancashbackloan.model.SimulatedValues
import java.text.NumberFormat
import java.util.*

class DataFormatter {

    fun getSimulatedValues(progressValue: Int) : SimulatedValues{
        val percentageValue = progressValue * 0.08
        return SimulatedValues(getMoneyFormat(progressValue), getMoneyFormat(percentageValue.toInt()))
    }

    fun getMoneyFormat(valueToFormat: Int): String {
        val format = NumberFormat.getCurrencyInstance(Locale( "pt", "BR" ))
        return format.format(valueToFormat).toString()
    }
}