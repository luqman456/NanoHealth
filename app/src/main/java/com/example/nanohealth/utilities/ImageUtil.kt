package com.example.nanohealth.utilities

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.nanohealth.R
import com.example.nanohealth.ui.NanoHealth

class ImageUtil {
    companion object {
        fun loadImage(imageView: ImageView, url: String?) {
            url?.let {
                Glide.with(NanoHealth.applicationContext())
                    .load(url)
                    .placeholder(R.drawable.main_logo)
                    .error(R.drawable.main_logo)
                    .into(imageView)
            }
        }
    }
}