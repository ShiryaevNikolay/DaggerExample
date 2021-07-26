package com.example.daggerapp.di.app

import com.example.daggerapp.MainActivity
import com.example.daggerapp.di.scopes.PerApplication
import dagger.Component

@PerApplication
@Component(modules = [Module::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}