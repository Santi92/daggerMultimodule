package com.sundevs.basecinemark

import com.marcosholgado.daggerplayground.di.CoreModule

import com.marcosholgado.mymodule.Feature1Module
import com.marcosholgado.mymodule.OtherActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {


    @ContributesAndroidInjector(modules = [Feature1Module::class])
    abstract fun otherActivity(): OtherActivity

    @ContributesAndroidInjector()
    abstract fun splashActivity(): SplashActivity
}