package com.example.daggerapp.domain

import android.net.Uri

data class ImageData(
    val uri: Uri,
    val name: String? = null,
    val size: Int = 0
)