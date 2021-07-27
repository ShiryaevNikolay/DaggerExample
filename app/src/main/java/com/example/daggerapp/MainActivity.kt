package com.example.daggerapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerapp.di.activity.ActivityModule
import com.example.daggerapp.di.activity.DaggerActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerActivityComponent.builder()
            .activityModule(ActivityModule())
            .appComponent((application as App).appComponent)
            .build()
            .injectMainActivity(this)

        presenter.showToast = {
            Toast.makeText(this, "Button was clicked!", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.button_btn).setOnClickListener {
            presenter.clickBtn()
        }
    }
}