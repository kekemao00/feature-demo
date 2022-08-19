package com.xingkeqi.featerdemo.hilt

import com.xingkeqi.featerdemo.BasePresenter
import com.xingkeqi.featerdemo.BaseView

interface HiltContract {

    interface View : BaseView<Presenter> {


    }

    interface Presenter : BasePresenter {

        fun startTiming()

    }
}