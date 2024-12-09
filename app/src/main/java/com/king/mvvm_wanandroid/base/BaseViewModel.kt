package com.king.mvvm_wanandroid.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    fun getFa(){
        viewModelScope.launch {

        }
    }
}