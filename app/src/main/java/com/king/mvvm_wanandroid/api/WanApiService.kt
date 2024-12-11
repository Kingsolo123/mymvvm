package com.king.mvvm_wanandroid.api

import com.king.mvvm_wanandroid.bean.LoginBean
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query

interface WanApiService {

    @POST("user/login")
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): WanJetpackResponse<LoginBean>

    @POST("user/register")
    suspend fun register(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("repassword") repassword: String
    ): WanJetpackResponse<LoginBean>

    companion object {
        private const val BASE_URL = "https://www.wanandroid.com/"

        fun create(): WanApiService {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
//                .cookieJar(LocalCookie())
//                .cookieJar(LocalCookieJar())
                .build()

            //注意：如果只是用Paging、Flow不需要LiveDataCallAdapterFactory或CoroutineCallAdapterFactory。
            //其实用了协程后，是不需要添加addCallAdapterFactory的
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(WanApiService::class.java)
        }
    }

}