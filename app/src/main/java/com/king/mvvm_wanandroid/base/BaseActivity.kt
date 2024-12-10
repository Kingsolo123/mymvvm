package com.king.mvvm_wanandroid.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.king.mvvm_wanandroid.databinding.ActivityMainBinding

abstract class BaseActivity<VIEW : ViewBinding> : AppCompatActivity() {
    private var _mBinding: VIEW? = null
    val binding get() = _mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mBinding = viewBinding(layoutInflater)
        val rootView = _mBinding?.root
        setContentView(rootView)
    }

    override fun onStart() {
        super.onStart()
        init()
    }

    abstract fun viewBinding(layoutInflater: LayoutInflater): VIEW

    abstract fun init()

    override fun onDestroy() {
        super.onDestroy()
        _mBinding = null
    }

}