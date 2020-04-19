package com.marcosholgado

import android.app.Activity
import com.marcosholgado.core.di.CoreComponentProvider
import com.marcosholgado.core.resource.CmkCoreSettings
import com.marcosholgado.daggerplayground.di.CoreComponent
import com.sundevs.basecinemark.di.DaggerAppComponent


import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
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
            .cmkCoreSettings(buildSetting())
            .build()
    }

    private fun buildSetting() = CmkCoreSettings.Builder()
        .addSalesChannel("ANDDROID")
        .addOptionalClientId("Colombia app")
        .connectApiToken("U3VuRGV2cyBXRUI")
        .logActive(true)
        .build();


    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {

        }
        return coreComponent
    }


}