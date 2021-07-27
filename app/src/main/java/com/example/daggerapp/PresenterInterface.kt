package com.example.daggerapp

import com.example.daggerapp.di.scopes.PerActivity

@PerActivity
interface PresenterInterface {

    fun clickBtn()
}