package com.pan.pancashbackloan.ui.simulation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pan.pancashbackloan.model.SimulatedValues
import com.pan.pancashbackloan.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.NumberFormat
import java.util.*

class SimulationViewModel: ViewModel() {

    val repository = Repository()

    private val _simulatedValues : MutableLiveData<SimulatedValues> by lazy {
        MutableLiveData<SimulatedValues>()
    }
    val simulatedValues: LiveData<SimulatedValues> get() = _simulatedValues

    fun getSimulatedValues(progressValue: Int) {
        viewModelScope.launch {
            val simulatedValues = withContext(Dispatchers.Default){
                repository.getSimulatedValues(progressValue)
            }
            _simulatedValues.value = simulatedValues
        }
    }
}