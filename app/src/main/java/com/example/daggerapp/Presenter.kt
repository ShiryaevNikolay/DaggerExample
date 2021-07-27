package com.example.daggerapp

import android.app.Application
import com.example.daggerapp.di.scopes.PerActivity
import com.example.daggerapp.di.scopes.PerApplication
import javax.inject.Inject

class Presenter constructor(
    private val app: Application
) : PresenterInterface {

    var showToast: (() -> Unit)? = null

    override fun clickBtn() {
        showToast?.invoke()
    }
}