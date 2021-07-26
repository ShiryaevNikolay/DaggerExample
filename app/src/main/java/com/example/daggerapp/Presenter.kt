package com.example.daggerapp

import android.app.Application
import com.example.daggerapp.di.scopes.PerActivity
import com.example.daggerapp.di.scopes.PerApplication
import javax.inject.Inject

@PerApplication
class Presenter @Inject constructor(
//    private val app: Application
) {

    var showToast: (() -> Unit)? = null

    fun clickBtn() {
        showToast?.invoke()
    }
}