package com.example.walmartapp

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.walmartapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var menuSwitch: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {

        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        // Implementación de menú
        menuSwitch =
            ActionBarDrawerToggle(this, binding.mainActivity, R.string.open, R.string.close)

        binding.mainActivity.addDrawerListener(menuSwitch)
        menuSwitch.syncState()

    }
}
