package com.king.mvvm_wanandroid.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.king.mvvm_wanandroid.base.BaseFragment
import com.king.mvvm_wanandroid.databinding.FragmentLoginBinding
import com.king.mvvm_wanandroid.viewmodel.LoginViewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    private val mViewModel: LoginViewModel by viewModels()

    //    private lateinit var mLoginBinding:FragmentLoginBinding
    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentLoginBinding {
//        mLoginBinding=DataBindingUtil.setContentView(this,R.layout.fragment_)
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    override fun init() {

    }
}