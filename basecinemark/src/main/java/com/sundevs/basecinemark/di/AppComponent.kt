package com.sundevs.basecinemark.di

import android.app.Application
import com.marcosholgado.core.di.AppScope
import com.marcosholgado.core.resource.CmkCoreSettings
import com.marcosholgado.daggerplayground.di.CoreModule
import com.sundevs.basecinemark.ActivityBindingModule

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


@Component(modules = [
    AndroidInjectionModule::class,
    ActivityBindingModule::class,
    CoreModule::class
    ]
)
@AppScope
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application):
                AppComponent.Builder

        @BindsInstance
        fun cmkCoreSettings(cmkCoreSettings: CmkCoreSettings):
                AppComponent.Builder

        fun build(): AppComponent
    }
}