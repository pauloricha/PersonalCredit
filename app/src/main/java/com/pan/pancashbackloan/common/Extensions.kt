package com.pan.pancashbackloan.common

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.pan.pancashbackloan.model.SimulatedValues
import java.text.NumberFormat
import java.util.*

fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
    observe(lifecycleOwner, object : Observer<T> {
        override fun onChanged(t: T?) {
            observer.onChanged(t)
            removeObserver(this)
        }
    })
}

fun getSimulatedValues(progressValue: Double) : SimulatedValues{
    val percentageValue = progressValue * 0.08
    return SimulatedValues(getMoneyFormat(progressValue), getMoneyFormat(percentageValue))
}

fun getMoneyFormat(valueToFormat: Double): String {
    val format = NumberFormat.getCurrencyInstance(Locale( "pt", "BR" ))
    return format.format(valueToFormat).toString()
}
