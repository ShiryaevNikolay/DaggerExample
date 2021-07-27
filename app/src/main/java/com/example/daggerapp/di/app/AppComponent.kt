package com.example.daggerapp.di.app

import android.app.Application
import com.example.daggerapp.di.scopes.PerApplication
import dagger.Component

@PerApplication
@Component(modules = [AppModule::class])
interface AppComponent {

    fun application(): Application
}