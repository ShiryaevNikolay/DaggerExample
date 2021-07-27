package com.example.daggerapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.daggerapp.di.activity.ActivityModule
import com.example.daggerapp.di.activity.DaggerActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: PresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerActivityComponent.builder()
            .appComponent((application as App).appComponent)
            .build()
            .injectMainActivity(this)

        (presenter as Presenter).showToast = { value ->
            Toast.makeText(this, "$value", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.button_btn).setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                presenter.clickBtn()
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 10)
            }
        }
    }
}