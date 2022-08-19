package com.xingkeqi.featerdemo.main

import android.annotation.SuppressLint
import android.os.Bundle
import com.xingkeqi.featerdemo.base.BaseActivity
import com.xingkeqi.featerdemo.feat.ctrip.CtripActivity
import com.xingkeqi.featerdemo.databinding.ActivityMainBinding
import com.xingkeqi.featerdemo.feat.rxdownload.RxDownloadActivity
import com.xingkeqi.featerdemo.hilt.HiltActivity

class MainActivity : BaseActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvRxDownload.setOnClickListener { RxDownloadActivity.start(this) }
        binding.tvCtrip.setOnClickListener { CtripActivity.start(this) }
        binding.tvView.setOnClickListener {}
        binding.tvTool.setOnClickListener {}
        binding.tvHilt.setOnClickListener { HiltActivity.start(this) }
    }
}