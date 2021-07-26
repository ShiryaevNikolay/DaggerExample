package com.example.daggerapp

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var presenter: Presenter

    @Inject
    lateinit var app: Application

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        presenter.showToast = {
//            Toast.makeText(this, "Button was clicked!", Toast.LENGTH_SHORT).show()
//        }

//        findViewById<Button>(R.id.button_btn).setOnClickListener {
//            presenter.clickBtn()
//        }
    }
}