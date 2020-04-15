package com.marcosholgado.daggerplayground.di

import android.app.Application
import com.marcosholgado.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBindingModule::class
    ],
    dependencies = [CoreComponent::class]
)
@AppScope
interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application):
                AppComponent.Builder

        fun coreComponent(coreComponent: CoreComponent):
                AppComponent.Builder

        fun build(): AppComponent
    }
}