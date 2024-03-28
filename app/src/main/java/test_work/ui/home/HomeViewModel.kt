package com.khdev.test_work.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _ctg1 = MutableLiveData<String>().apply {
        value = "Пицца"
    }
    private val _ctg2 = MutableLiveData<String>().apply {
        value = "Комбо"
    }
    private val _ctg3 = MutableLiveData<String>().apply {
        value = "Десерты"
    }
    private val _ctg4 = MutableLiveData<String>().apply {
        value = "Напитки"
    }

    val ctg1: LiveData<String> = _ctg1
    val ctg2: LiveData<String> = _ctg2
    val ctg3: LiveData<String> = _ctg3
    val ctg4: LiveData<String> = _ctg4
}