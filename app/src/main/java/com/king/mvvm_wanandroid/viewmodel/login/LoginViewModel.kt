package com.king.mvvm_wanandroid.viewmodel.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.king.mvvm_wanandroid.api.WanApiService
import com.king.mvvm_wanandroid.api.WanJetpackRepository
import com.king.mvvm_wanandroid.base.BaseViewModel
import com.king.mvvm_wanandroid.bean.LoginBean
import kotlinx.coroutines.launch

class LoginViewModel : BaseViewModel() {

    /**
     * 登录账号
     */
    val username: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    /**
     * 登录密码
     */
    val password: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    /**
     * 确认登录密码
     */
    val repassword: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val userBean: MutableLiveData<LoginBean> by lazy {
        MutableLiveData<LoginBean>()
    }
    private var repository: WanJetpackRepository


    init {
        val api = WanApiService.create()
        repository = WanJetpackRepository(api)
    }

//    fun login() = liveData {
//        emit(repository.login(username.value ?: "", password.value ?: ""))
//    }

    fun login() {
        Log.e("feng", "username==${username.value}    password==${password.value}")
        viewModelScope.launch {
            try {
                val data = repository.login(username.value?:"", password.value?:"")
                if (data.errorCode == 0) {
                    userBean.value = data.data
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }


    fun register() = liveData {
        emit(repository.register(username.value ?: "", password.value ?: "", password.value ?: ""))
    }


}