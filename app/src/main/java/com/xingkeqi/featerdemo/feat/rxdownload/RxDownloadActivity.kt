package com.xingkeqi.featerdemo.feat.rxdownload

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.xingkeqi.featerdemo.base.BaseActivity
import com.xingkeqi.featerdemo.databinding.ActivityRxdownloadBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import zlc.season.rxdownload4.delete
import zlc.season.rxdownload4.download
import zlc.season.rxdownload4.file

class RxDownloadActivity : BaseActivity() {
    private val TAG: String = this.javaClass.simpleName
    private lateinit var mDisposable: Disposable

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityRxdownloadBinding = ActivityRxdownloadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i(TAG, "onCreate:  start download!!")

        url.delete()

        mDisposable = url.download().observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    Log.i(
                        TAG,
                        "onNext: progress=${it.downloadSizeStr()}/${it.totalSizeStr()}"
                    )
                    binding.tvMsg.text = "正在下载: ${it.downloadSizeStr()}/${it.totalSizeStr()}"
                },
                onComplete = {
                    Log.i(TAG, "onComplete: ")
                    binding.tvMsg.text = "下载完成: ${url.file().absolutePath}"
                },
                onError = {
                    Log.w(TAG, "onError: ", it)
                    binding.tvMsg.text = "下载失败: ${it.localizedMessage}"
                })
    }


    override fun onDestroy() {
        super.onDestroy()
        if (::mDisposable.isInitialized) mDisposable.dispose()
    }

    companion object {
        const val url =
            "https://xkq-london.oss-eu-west-1.aliyuncs.com/8e897f2a37bc40acac61265b1dd1ceb9.up"

        fun start(context: Context) {
            context.startActivity(Intent(context, RxDownloadActivity::class.java))
        }
    }
}