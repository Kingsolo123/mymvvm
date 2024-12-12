package com.king.mvvm_wanandroid.viewmodel.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.king.mvvm_wanandroid.api.WanApiService
import com.king.mvvm_wanandroid.api.WanJetpackRepository
import com.king.mvvm_wanandroid.base.BaseViewModel
import com.king.mvvm_wanandroid.bean.HomeBanner
import com.king.mvvm_wanandroid.bean.HomeBannerItem
import com.king.mvvm_wanandroid.bean.HomeListBean
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    private var repository: WanJetpackRepository


    init {
        val api = WanApiService.create()
        repository = WanJetpackRepository(api)
        getApiBanner()
    }

    val homeBannerBean: MutableLiveData<HomeBanner> by lazy {
        MutableLiveData<HomeBanner>()
    }

    val homeListBean: MutableLiveData<HomeListBean> by lazy {
        MutableLiveData<HomeListBean>()
    }

    private fun getApiBanner() {
        viewModelScope.launch {
            val data = repository.getBanner()
            if (data.errorCode == 0) {
                homeBannerBean.value = data.data
                Log.d("feng", "返回 data=${data.data}")
            } else {
                Log.d("feng", "错误信息==${data.errorMsg}")
            }
        }
    }
}