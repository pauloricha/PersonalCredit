package com.pan.pancashbackloan.repository

import com.pan.pancashbackloan.common.DataFormatter
import com.pan.pancashbackloan.model.SimulatedValues
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository: IRepository{

    val dataFormatter = DataFormatter()

    override suspend fun getSimulatedValues(progressValue: Double): SimulatedValues {
        return withContext(Dispatchers.Default){
            dataFormatter.getSimulatedValues(progressValue)
        }
    }
}