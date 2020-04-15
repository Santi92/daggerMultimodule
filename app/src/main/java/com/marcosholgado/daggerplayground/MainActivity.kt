package com.marcosholgado.daggerplayground

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marcosholgado.OtherObject
import com.marcosholgado.core.ExpensiveObject
import com.marcosholgado.mymodule.OtherActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var expensiveObject: ExpensiveObject

    @Inject
    lateinit var otherObject: OtherObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        button.setOnClickListener {
            startActivity(Intent(this, OtherActivity::class.java))
        }
    }
}
