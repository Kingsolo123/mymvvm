package com.king.mvvm_wanandroid.api


import com.king.mvvm_wanandroid.bean.LoginBean
import retrofit2.Call
import retrofit2.http.Query

class WanJetpackRepository constructor(private val api: WanApiService) {

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
}