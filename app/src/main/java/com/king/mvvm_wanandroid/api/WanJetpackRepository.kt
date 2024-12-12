package com.king.mvvm_wanandroid.api


import com.king.mvvm_wanandroid.bean.HomeBanner
import com.king.mvvm_wanandroid.bean.HomeBean
import com.king.mvvm_wanandroid.bean.LoginBean


class WanJetpackRepository (private val api: WanApiService) {

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

    suspend fun getBanner():WanJetpackResponse<HomeBanner>{
        return api.getHomeBanner()
    }

    suspend fun get(path:Int):WanJetpackResponse<HomeBean>{
        return api.getHomeArticle(path)
    }
}