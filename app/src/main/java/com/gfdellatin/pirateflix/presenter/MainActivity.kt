package com.gfdellatin.pirateflix.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gfdellatin.pirateflix.MainFragment
import com.gfdellatin.pirateflix.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}