package com.example.daggerapp.di.activity

import com.example.daggerapp.Presenter
import com.example.daggerapp.PresenterInterface
import com.example.daggerapp.di.scopes.PerActivity
import dagger.Binds
import dagger.Module

@Module
abstract class ActivityModule {

    @PerActivity
    @Binds
    abstract fun providePresenter(presenter: Presenter): PresenterInterface
}