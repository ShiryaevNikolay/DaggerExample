package com.example.daggerapp

import android.app.Application
import com.example.daggerapp.di.app.AppComponent
import com.example.daggerapp.di.app.DaggerAppComponent
import com.example.daggerapp.di.app.AppModule

class App : Application() {

    var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}