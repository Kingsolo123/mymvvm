package com.king.mvvm_wanandroid.api

import com.king.mvvm_wanandroid.bean.HomeBanner
import com.king.mvvm_wanandroid.bean.HomeBean
import com.king.mvvm_wanandroid.bean.LoginBean
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
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

    /**
     * 获取首页文章列表
     */
    @GET("/article/list/{page}/json")
    suspend fun getHomeArticle(
        @Path("page") page: Int
    ): WanJetpackResponse<HomeBean>

    @GET("/banner/json")
    suspend fun getHomeBanner(): WanJetpackResponse<HomeBanner>

    @GET("/banner/json")
    suspend fun getHomeBanner1(): WanJetpackResponse<HomeBanner>

    companion object {
        private const val BASE_URL = "https://www.wanandroid.com/"

        fun create(): WanApiService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
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
//                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(WanApiService::class.java)
        }
    }

}