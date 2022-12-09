package com.testing.thirdtestappforrandomlessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var fragment2_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // sets at start of activity on the top of the screen
        supportFragmentManager.beginTransaction().replace(R.id.place_holder, FirstFragment.newInstance()).commit()

        // sets only on button click
        fragment2_button = findViewById(R.id.button_frag2)
        fragment2_button.setOnClickListener {
            supportFragmentManager.beginTransaction().hide(SecondFragment()).commit()
        }
    }
}