package com.marcosholgado.daggerplayground.di

import android.app.Application
import com.marcosholgado.core.ExpensiveObject


//@Singleton
//@Component(modules = [CoreModule::class])
interface CoreComponent {

   // @Component.Builder
    interface Builder {

        //@BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }

    fun getExpensiveObject(): ExpensiveObject

}