package com.yeonnex.jetpackapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() { // 뷰모델 상속
    private val usd_to_eu_rate = 0.74f
    private var dollarText = ""
    private var result: MutableLiveData<Float> = MutableLiveData()

    fun setAmount(value: String){
        this.dollarText = value
        this.result.value = value.toFloat() * usd_to_eu_rate
    }

    fun getResult(): MutableLiveData<Float>{
        return result
    }
}