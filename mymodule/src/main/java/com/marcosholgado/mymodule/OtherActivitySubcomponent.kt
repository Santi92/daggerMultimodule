package com.marcosholgado.mymodule

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [Feature1Module::class])
interface OtherActivitySubcomponent: AndroidInjector<OtherActivity> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<OtherActivity>()
}