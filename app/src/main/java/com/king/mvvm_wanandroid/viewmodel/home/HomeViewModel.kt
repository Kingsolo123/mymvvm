package com.king.mvvm_wanandroid.viewmodel.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.king.mvvm_wanandroid.api.WanApiService
import com.king.mvvm_wanandroid.api.WanJetpackRepository
import com.king.mvvm_wanandroid.api.WanJetpackResponse
import com.king.mvvm_wanandroid.base.BaseViewModel
import com.king.mvvm_wanandroid.bean.HomeBanner
import com.king.mvvm_wanandroid.bean.HomeBannerItem
import com.king.mvvm_wanandroid.bean.HomeBean
import com.king.mvvm_wanandroid.bean.HomeListBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : BaseViewModel() {

    private var repository: WanJetpackRepository


    init {
        val api = WanApiService.create()
        repository = WanJetpackRepository(api)
        getApiBanner()
//        getHomeList()
//        getBanner()
    }

    val homeBannerBean: MutableLiveData<HomeBanner> by lazy {
        MutableLiveData<HomeBanner>()
    }

    val homeListBean: MutableLiveData<HomeBean> by lazy {
        MutableLiveData<HomeBean>()
    }


//    fun getHomeArticle(): Flow<PagingData<ApiArticle>> {
//        val newResult: Flow<PagingData<ApiArticle>> =
//            repository.getHomeArticle().cachedIn(viewModelScope)
//        currentArticleResult = newResult
//        return newResult
//    }

//    fun fetchPokemonInfo1(name: String) = viewModelScope.launch {
//        pokemonRepository.fetchPokemonInfo(name)
//            .onStart {
//                // 在调用 flow 请求数据之前，做一些准备工作，例如显示正在加载数据的按钮
//                mLoading.set(true)
//            }
//            .catch {
//                // 捕获上游出现的异常
//                mLoading.set(false)
//            }
//            .onCompletion {
//                // 请求完成
//                mLoading.set(false)
//            }
//            .collectLatest { result ->
//                result.doFailure { throwable ->
//                    _failure.value = throwable?.message ?: "failure"
//                }
//
//                result.doSuccess { value ->
//                    _pokemon.postValue(value)
//                }
//            }
//    }

    // Backing property to avoid state updates from other classes
    private val _uiBannerState = MutableStateFlow(HomeBanner())

    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<HomeBanner> = _uiBannerState


    fun getBanner() = viewModelScope.launch {
        repository.getBanner().collect { response ->
//            homeBannerBean.value = response.data
//            _uiBannerState.value = response
            response?.let {
                _uiBannerState.value = it
            }
        }
    }


    private fun getApiBanner() {
//        viewModelScope.launch {
//            val flow1 = repository.getBanner()
//            val flow2 = repository.getHomeArticle(0)
//            flow1.zip(flow2) { banner, home ->
//                Log.d("feng", "zip")
//                homeBannerBean.value = banner
//                homeListBean.value = home
//                Log.d("feng", "返回 banner data=${banner} \n home.data==${home}")
//            }.collectLatest {
//
//            }
//        }
        Log.d("feng", "start")
        viewModelScope.launch {
            Log.d("feng", "Thread=${Thread.currentThread()} viewModelScope.launch")
            val data = repository.getHomeBanner1()
            val str = getString()
            Log.d("feng", "Thread=${Thread.currentThread()} str==${str}")
            Log.d("feng", "Thread=${Thread.currentThread()} data==${data.data}")
        }
        Log.d("feng", "end")
    }


    private suspend fun getString(): String {
        return withContext(Dispatchers.IO) {
            Log.d("feng", "Thread=${Thread.currentThread()} getString")
            "反动打"
        }
    }

    fun getHomeList() {
        viewModelScope.launch {
            val data = repository.getHomeArticle(0)
//            if (data.errorCode == 0) {
//                homeListBean.value = data.data
//            }
        }
    }
}