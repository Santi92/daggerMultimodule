package com.marcosholgado.mymodule

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.calculator.usecase.SumUseCase
import com.marcosholgado.core.ExpensiveObject
import com.marcosholgado.core.resource.CmkCoreSettings
import com.sundevs.basecinemark.resource.StringsProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class OtherActivity : DaggerAppCompatActivity() {

    //@Inject
    lateinit var expensiveObject: ExpensiveObject

    @Inject
    lateinit var sumUseCase: SumUseCase

    @Inject
    lateinit var cmkCoreSettings: CmkCoreSettings


    lateinit var firstNumberEditText: EditText
    lateinit var secondNumberEditText: EditText
    lateinit var resultTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)


        val textView = findViewById<TextView>(R.id.textView)
        textView.text = cmkCoreSettings.getOptionalClientId()
        bindViews()
        bindListeners()

    }

    private fun calculateSum() {
        val firstNumberString = firstNumberEditText.text.toString()
        val secondNumberString = secondNumberEditText.text.toString()

        if(TextUtils.isEmpty(firstNumberString) ||
            TextUtils.isEmpty(secondNumberString)) {
            showFailureMessage(getString(R.string.both_numbers_must_have_value))
        } else {
            sumUseCase.execute(firstNumberString.toInt(), secondNumberString.toInt()).let {
                when (it) {
                    is SumUseCase.Result.Success -> resultTextView.text = it.result.toString()
                    is SumUseCase.Result.Failure -> showFailureMessage(it.message)
                }
            }
        }
    }

    private fun showFailureMessage(message: String) {
        resultTextView.text = ""
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun bindViews() {
        firstNumberEditText = findViewById(R.id.first_number_edittext)
        secondNumberEditText = findViewById(R.id.second_number_edittext)
        resultTextView = findViewById(R.id.result_textview)
    }

    private fun bindListeners() {
        findViewById<Button>(R.id.button_calculate).setOnClickListener {
            calculateSum()
        }
    }
}
