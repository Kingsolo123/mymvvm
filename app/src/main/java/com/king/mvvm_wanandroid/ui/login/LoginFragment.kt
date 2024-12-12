package com.king.mvvm_wanandroid.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.king.mvvm_wanandroid.R
import com.king.mvvm_wanandroid.base.BaseFragment
import com.king.mvvm_wanandroid.databinding.FragmentLoginBinding
import com.king.mvvm_wanandroid.viewmodel.login.LoginViewModel
import kotlinx.coroutines.GlobalScope

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    private val mViewModel: LoginViewModel by viewModels()

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    override fun init() {
        binding.userModel = mViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.closeLogin.setOnClickListener {
            findNavController().navigateUp()
        }


        mViewModel.userBean.observe(viewLifecycleOwner) { data ->
            Log.d("feng", "订阅登陆成功 ==${data}")
        }

        binding.setLoginClickListener {
            mViewModel.login()
//            mViewModel.login1().collect { data ->
//                Log.d("feng", "订阅登陆成功 ==${data}")
//            }
        }

//        binding.registerButton.setOnClickListener {
//            mViewModel.register()
//        }
    }
}