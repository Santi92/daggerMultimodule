package com.marcosholgado.daggerplayground.di

import android.app.Application
import com.marcosholgado.MyApplication
import com.marcosholgado.core.di.AppScope
import com.sundevs.basecinemark.ActivityBindingModule

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


@Component(modules = [
    AndroidInjectionModule::class,
    ActivityBindingModule::class,
    CoreModule::class
    ]
)
@AppScope
interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application):
                AppComponent.Builder


        fun build(): AppComponent
    }
}