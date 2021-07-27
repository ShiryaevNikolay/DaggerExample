package com.example.daggerapp.di.activity

import android.app.Application
import com.example.daggerapp.Presenter
import com.example.daggerapp.di.scopes.PerActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @PerActivity
    @Provides
    fun providePresenter(app: Application) = Presenter(app)
}