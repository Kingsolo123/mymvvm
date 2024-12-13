package com.king.mvvm_wanandroid.api


import android.util.Log
import com.king.mvvm_wanandroid.bean.HomeBanner
import com.king.mvvm_wanandroid.bean.HomeBean
import com.king.mvvm_wanandroid.bean.LoginBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext


class WanJetpackRepository(private val api: WanApiService) {

    suspend fun login(
        username: String,
        password: String
    ): WanJetpackResponse<LoginBean> {
        return api.login(username, password)
    }

    suspend fun register(
        username: String,
        password: String, repassword: String
    ): WanJetpackResponse<LoginBean> {
        return api.register(username, password, repassword)
    }

    suspend fun getBanner(): Flow<HomeBanner?> {
        val data = handleFlowResponse(api.getHomeBanner())
//        val data = api.getHomeBanner().data
//        return api.getHomeBanner().data

        return flow { emit(data) }
    }

    suspend fun getHomeArticle(path: Int): Flow<HomeBean?> {
        val data = handleFlowResponse(api.getHomeArticle(path))
//        val data = api.getHomeBanner().data
//        return api.getHomeBanner().data

        return flow { emit(data) }

    }

    suspend fun getHomeBanner1():WanJetpackResponse<HomeBanner>{
        return withContext(Dispatchers.IO) {
            Log.d("feng","Thread=${Thread.currentThread()} getHomeBanner1")
            api.getHomeBanner1()
        }
//        return api.getHomeBanner1()
    }
}