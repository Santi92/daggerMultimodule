package com.sundevs.basecinemark.resource

import android.app.Application
import android.content.Context
import androidx.annotation.StringRes

class StringsProvider(
    val context: Context
) {

    fun getString(@StringRes id: Int): String = context.getString(id)

}