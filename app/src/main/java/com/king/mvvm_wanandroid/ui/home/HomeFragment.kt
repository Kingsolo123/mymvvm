package com.king.mvvm_wanandroid.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.king.mvvm_wanandroid.base.BaseFragment
import com.king.mvvm_wanandroid.databinding.FragmentHomeBinding
import com.king.mvvm_wanandroid.ui.adapter.HomeBannerAdapter
import com.king.mvvm_wanandroid.viewmodel.home.HomeViewModel

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
            Log.d("feng","收到banner数据")
            mHomeBannerAdapter.setData(data)
            mHomeBannerAdapter.notifyDataSetChanged()
        }
    }
}