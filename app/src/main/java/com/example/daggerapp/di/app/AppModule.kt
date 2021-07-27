package com.example.daggerapp.di.app

import android.app.Application
import com.example.daggerapp.di.scopes.PerApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: Application) {

    @PerApplication
    @Provides
    fun provideApp(): Application = app
}