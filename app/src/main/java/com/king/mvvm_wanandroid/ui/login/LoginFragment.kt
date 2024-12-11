package com.king.mvvm_wanandroid.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
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
        binding.userModel = mViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.closeLogin.setOnClickListener {
            findNavController().navigateUp()
        }


        mViewModel.userBean.observe(viewLifecycleOwner) { data ->
            Log.d("feng", "订阅登陆成功 ==${data}")
        }

        binding.setLoginClickListener {
            Log.d("feng", "UI 用户名 ==${binding.username.editText?.text}  密码 ==${binding.password.editText?.text}")
            Log.d("feng", "UI1 用户名 ==${mViewModel.username.value}  密码 ==${mViewModel.password.value}")
            mViewModel.login()
        }

//        binding.registerButton.setOnClickListener {
//            mViewModel.register()
//        }
    }
}