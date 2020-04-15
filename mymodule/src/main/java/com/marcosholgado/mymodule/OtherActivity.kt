package com.marcosholgado.mymodule

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.marcosholgado.core.ExpensiveObject
import com.marcosholgado.core.di.CoreInjectHelper
import dagger.android.AndroidInjection
import javax.inject.Inject

class OtherActivity : AppCompatActivity() {

    @Inject
    lateinit var expensiveObject: ExpensiveObject

    @Inject
    lateinit var text: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        AndroidInjection.inject(this)


        val textView = findViewById<TextView>(R.id.textView)
        textView.text = text
    }
}
