package com.sundevs.cmkecuador

import android.app.Activity
import com.marcosholgado.core.di.CoreComponentProvider
import com.marcosholgado.core.resource.CmkCoreSettings
import com.marcosholgado.daggerplayground.di.CoreComponent
import com.sundevs.basecinemark.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class EcuadorApplication : DaggerApplication(), CoreComponentProvider {

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
        .addSalesChannel("ANDDROID_EC")
        .addOptionalClientId("Ecuador app")
        .connectApiToken("2sdjadkjab")
        .logActive(true)
        .build();


    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {

        }
        return coreComponent
    }


}