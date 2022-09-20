package com.xingkeqi.featerdemo.feat.ctrip

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xingkeqi.featerdemo.databinding.ActivityCtripBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.coroutines.*

class CtripActivity : AppCompatActivity() {

    private val job = Job()
    private val scope = CoroutineScope(job)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCtripBinding.inflate(layoutInflater)
        setContentView(binding.root)


        scope.launch {}
        scope.launch {}

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, CtripActivity::class.java))
        }
    }
}