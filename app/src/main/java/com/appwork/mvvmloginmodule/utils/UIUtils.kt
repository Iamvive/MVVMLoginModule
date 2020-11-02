package com.appwork.mvvmloginmodule.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

fun Context.showToast(message: String, lenght: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, lenght).show()
}

fun ProgressBar.show() {
    visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    visibility = View.GONE
}