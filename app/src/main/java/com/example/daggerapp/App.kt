package com.example.daggerapp

import android.app.Application
import com.example.daggerapp.di.app.DaggerAppComponent
import com.example.daggerapp.di.app.AppModule

class App : Application() {

    val appComponent = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .build()
}