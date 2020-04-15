package com.marcosholgado.daggerplayground.di

import com.marcosholgado.MyApplication
import com.marcosholgado.mymodule.OtherActivityModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    MainActivityModule::class,
    OtherActivityModule::class
    ],
    dependencies = [CoreComponent::class]
)
@AppScope
interface AppComponent {
    fun inject(application: MyApplication)
}