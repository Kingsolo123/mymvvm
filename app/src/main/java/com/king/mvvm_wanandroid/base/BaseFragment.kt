package com.king.mvvm_wanandroid.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VIEW : ViewBinding> : Fragment() {

    private var _mBinding: VIEW? = null
    val binding get() = _mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _mBinding=viewBinding(inflater,container,savedInstanceState)
        return _mBinding?.root
    }

    override fun onStart() {
        super.onStart()
        init()
    }



    abstract fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): VIEW

    abstract fun init()

    override fun onDestroy() {
        super.onDestroy()
        _mBinding=null
    }
}