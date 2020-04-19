package com.sundevs.basecinemark

import android.content.Context
import android.content.Intent

object Navigation {

    fun navigationModuleOne(context: Context){
        val intent = Intent().setClassName(
            context,
            "com.marcosholgado.mymodule.OtherActivity"
        )
        context.startActivity(intent)
    }
}