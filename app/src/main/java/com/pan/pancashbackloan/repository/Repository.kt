package com.pan.pancashbackloan.repository

import com.pan.pancashbackloan.common.DataFormatter
import com.pan.pancashbackloan.model.SimulatedValues
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository: IRepository{

    val dataFormatter = DataFormatter()

    fun getLoanApproved(): Int {
        return 1200
    }

    override suspend fun getSimulatedValues(progressValue: Int): SimulatedValues {
        return withContext(Dispatchers.Default){
            dataFormatter.getSimulatedValues(progressValue)
        }
    }
}