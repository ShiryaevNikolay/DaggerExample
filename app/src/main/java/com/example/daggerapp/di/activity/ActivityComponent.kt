package com.example.daggerapp.di.activity

import com.example.daggerapp.MainActivity
import com.example.daggerapp.di.app.AppComponent
import com.example.daggerapp.di.scopes.PerActivity
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun injectMainActivity(mainActivity: MainActivity)
}