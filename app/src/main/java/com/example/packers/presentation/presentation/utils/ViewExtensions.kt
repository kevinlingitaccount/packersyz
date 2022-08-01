package com.example.packers.presentation.utils.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
    Glide.with(context)
        .load(url)
        .error(android.R.drawable.stat_notify_error)
        .fallback(android.R.drawable.stat_notify_error)
        .placeholder(android.R.drawable.stat_notify_error)
        .into(this)
}