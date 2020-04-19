package com.sundevs.basecinemark

import android.content.Context
import android.content.Intent
import com.marcosholgado.mymodule.OtherActivity

object Navigation {

    fun navigationModuleOne(context: Context){
        context.startActivity(Intent(context, OtherActivity::class.java))
    }
}