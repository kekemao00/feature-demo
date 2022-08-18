package com.xingkeqi.featerdemo.feat.ctrip

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xingkeqi.featerdemo.databinding.ActivityCtripBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class CtripActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCtripBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val job = Job()
        val scope = CoroutineScope(job)

        scope.launch {}
        scope.launch {}
        scope.cancel()

    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, CtripActivity::class.java))
        }
    }
}