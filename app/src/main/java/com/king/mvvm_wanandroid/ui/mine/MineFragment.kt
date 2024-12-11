package com.king.mvvm_wanandroid.ui.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.king.mvvm_wanandroid.R
import com.king.mvvm_wanandroid.base.BaseFragment
import com.king.mvvm_wanandroid.databinding.FragmentMineBinding

class MineFragment : BaseFragment<FragmentMineBinding>() {

    override fun viewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentMineBinding {
        return FragmentMineBinding.inflate(inflater, container, false)
    }

    override fun init() {
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_mine_fragment_to_loginFragment)
        }
    }


}