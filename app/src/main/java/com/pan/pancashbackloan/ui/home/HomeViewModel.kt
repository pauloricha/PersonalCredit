package com.pan.pancashbackloan.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pan.pancashbackloan.repository.Repository

class HomeViewModel : ViewModel() {

    val repository = Repository()

    private val _loanApproved : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val loanApproved: LiveData<Int> get() = _loanApproved

    fun getLoanApproved() {
        _loanApproved.value = repository.getLoanApproved()
    }

    fun getLoadApproved(): Int {
        if(_loanApproved.value != null) {
            return _loanApproved.value!!
        } else {
            return 0
        }
    }
}