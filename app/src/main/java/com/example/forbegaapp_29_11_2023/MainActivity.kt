package com.example.forbegaapp_29_11_2023

import android.app.Activity
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.forbegaapp_29_11_2023.data.preferences.UserEnteredSharedPref
import com.example.forbegaapp_29_11_2023.databinding.ActivityMainBinding
import com.example.forbegaapp_29_11_2023.presentation.on_boarding_screen.OnBoardingScreenFragment
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}