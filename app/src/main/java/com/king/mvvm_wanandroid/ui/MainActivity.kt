package com.king.mvvm_wanandroid.ui

import android.os.Bundle
import android.view.LayoutInflater

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.king.mvvm_wanandroid.R
import com.king.mvvm_wanandroid.base.BaseActivity
import com.king.mvvm_wanandroid.databinding.ActivityMainBinding
import com.king.mvvm_wanandroid.databinding.ActivityMainBinding.*

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNav.setupWithNavController(navController)

//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    override fun viewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return inflate(layoutInflater)
    }

    override fun init() {

    }
}