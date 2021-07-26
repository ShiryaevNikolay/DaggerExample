package com.example.daggerapp

import android.app.Application
import com.example.daggerapp.di.app.DaggerAppComponent
import com.example.daggerapp.di.app.Module

class App : Application() {

    val appComponent = DaggerAppComponent.builder()
        .module(Module(this))
        .build()
}