package com.king.mvvm_wanandroid.api

data class WanJetpackResponse<T>(
    val data: T,
    val errorCode: Int,
    val errorMsg: String
)
