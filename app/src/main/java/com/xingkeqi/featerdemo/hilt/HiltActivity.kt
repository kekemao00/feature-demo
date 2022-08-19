package com.xingkeqi.featerdemo.hilt

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.xingkeqi.featerdemo.R
import com.xingkeqi.featerdemo.base.BaseActivity
import com.xingkeqi.featerdemo.databinding.ActivityHiltBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Hilt 依赖注入的
 * https://juejin.cn/post/7003552331962777637
 */
@AndroidEntryPoint
class HiltActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHiltBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.tvMsg.setText(R.string.hilt)

//        val fragmentManager=supportFragmentManager
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, HiltActivity::class.java))
        }
    }
}