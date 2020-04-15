package com.marcosholgado.mymodule

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [OtherActivitySubcomponent::class])
abstract class OtherActivityModule {

    @Binds
    @IntoMap
    @ClassKey(OtherActivity::class)
    internal abstract fun bindMainActivityInjectorFactory(
        builder: OtherActivitySubcomponent.Builder
    ): AndroidInjector.Factory<*>
}