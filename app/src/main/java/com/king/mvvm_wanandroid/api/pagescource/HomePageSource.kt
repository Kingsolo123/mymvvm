package com.king.mvvm_wanandroid.api.pagescource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.king.mvvm_wanandroid.api.WanApiService
import com.king.mvvm_wanandroid.bean.HomeListBean

class HomePageSource(val api: WanApiService) :
    PagingSource<Int, HomeListBean>() {
    override fun getRefreshKey(state: PagingState<Int, HomeListBean>): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
//        }
        return 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomeListBean> {
        try {
            val nextPageNumber = params.key ?: 0
            val response = api.getHomeArticle(nextPageNumber)
            return LoadResult.Page(
                data = response.data.datas,
                prevKey = if (nextPageNumber == 0) null else nextPageNumber - 1,
                nextKey = if (nextPageNumber == response.data.pageCount) null else nextPageNumber + 1
            )
        } catch (e: Exception) {
            Log.d("feng", "分页请求错误：${e.message}")
            return LoadResult.Error(e)
        }
    }
}