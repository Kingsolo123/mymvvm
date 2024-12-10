package com.king.mvvm_wanandroid.ui.wechat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.king.mvvm_wanandroid.base.BaseFragment
import com.king.mvvm_wanandroid.databinding.FragmentWechatBinding

class WechatFragment : BaseFragment<FragmentWechatBinding>() {


    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentWechatBinding {
        return FragmentWechatBinding.inflate(inflater, container, false)
    }

    override fun init() {

    }
}