package com.pan.pancashbackloan.repository

import com.pan.pancashbackloan.model.SimulatedValues

interface IRepository {
   suspend fun getSimulatedValues(progressValue: Int): SimulatedValues
}