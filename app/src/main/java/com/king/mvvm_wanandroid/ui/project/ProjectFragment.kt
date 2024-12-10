package com.king.mvvm_wanandroid.ui.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.king.mvvm_wanandroid.base.BaseFragment
import com.king.mvvm_wanandroid.databinding.FragmentProjectBinding

class ProjectFragment : BaseFragment<FragmentProjectBinding>() {
    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentProjectBinding {
        return FragmentProjectBinding.inflate(inflater,container,false)
    }

    override fun init() {

    }

}