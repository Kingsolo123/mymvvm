package com.king.mvvm_wanandroid.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.recyclerview.widget.LinearLayoutManager
import com.king.mvvm_wanandroid.base.BaseFragment
import com.king.mvvm_wanandroid.databinding.FragmentHomeBinding
import com.king.mvvm_wanandroid.ui.adapter.HomeBannerAdapter
import com.king.mvvm_wanandroid.ui.adapter.HomeListAdapter
import com.king.mvvm_wanandroid.viewmodel.home.HomeViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var mHomeBannerAdapter: HomeBannerAdapter
    private val mHomeListAdapter: HomeListAdapter by lazy {
        HomeListAdapter()
    }
    private val mHomeModel: HomeViewModel by viewModels()
    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun init() {
        mHomeBannerAdapter = HomeBannerAdapter()
        binding.homeViewPager.adapter = mHomeBannerAdapter
        binding.lifecycleOwner = viewLifecycleOwner
        mHomeModel.homeBannerBean.observe(viewLifecycleOwner) { data ->
            mHomeBannerAdapter.setData(data)
        }


        binding.homeRecycleView.apply {
            this.layoutManager = LinearLayoutManager(activity)
            this.adapter = mHomeListAdapter
        }
//        mHomeListAdapter.refresh()
        viewLifecycleOwner.lifecycleScope.launch {
            mHomeModel.getHomeArticle().collectLatest {
                mHomeListAdapter.submitData(it)
            }
//            mHomeListAdapter.withLoadStateFooter()
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                mHomeModel.uiState.collect { uiState ->
//                    Log.d("feng","收到首页banner")
//                    mHomeBannerAdapter.setData(uiState)
//                }
//            }
        }

    }

}