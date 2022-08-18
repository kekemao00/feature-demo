package com.xingkeqi.featerdemo.extension

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(text: String, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, text, duration).show()
}

fun View.showSnackbar(resId: Int, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, resId, duration).show()
}

fun View.showSnackbar(
    text: String,
    duration: Int = Snackbar.LENGTH_LONG,
    actionText: String? = null,
    block: (() -> Unit)? = null
) {
    Snackbar.make(this, text, duration).apply {
        if (actionText != null && block != null) setAction(actionText) { block() }
        show()
    }
}

fun View.showSnackbar(
    resId: Int,
    duration: Int = Snackbar.LENGTH_LONG,
    actionText: String? = null,
    block: (() -> Unit)? = null
) {
    Snackbar.make(this, resId, duration).apply {
        if (actionText != null && block != null) setAction(actionText) { block() }
        show()
    }
}



