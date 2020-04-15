package com.marcosholgado

import android.app.Activity
import android.app.Application
import com.marcosholgado.core.di.CoreComponentProvider
import com.marcosholgado.daggerplayground.di.CoreComponent
import com.marcosholgado.daggerplayground.di.DaggerAppComponent
import com.marcosholgado.daggerplayground.di.DaggerCoreComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MyApplication : DaggerApplication(), CoreComponentProvider {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    private lateinit var coreComponent: CoreComponent

    override fun applicationInjector():
            AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .application(this)
            .coreComponent(provideCoreComponent())
            .build()
    }

    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            coreComponent = DaggerCoreComponent
                .builder()
                .build()
        }
        return coreComponent
    }


}