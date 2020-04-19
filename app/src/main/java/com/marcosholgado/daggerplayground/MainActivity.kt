package com.marcosholgado.daggerplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sundevs.basecinemark.Navigation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            Navigation.navigationModuleOne(this)
        }
    }
}
