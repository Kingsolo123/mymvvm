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
import com.king.mvvm_wanandroid.base.BaseFragment
import com.king.mvvm_wanandroid.databinding.FragmentHomeBinding
import com.king.mvvm_wanandroid.ui.adapter.HomeBannerAdapter
import com.king.mvvm_wanandroid.viewmodel.home.HomeViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var mHomeBannerAdapter: HomeBannerAdapter
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

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                mHomeModel.uiState.collect{
                    uiState-> mHomeBannerAdapter.setData(uiState)
                }
            }
        }

    }

}