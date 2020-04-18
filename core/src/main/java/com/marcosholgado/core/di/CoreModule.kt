package com.marcosholgado.daggerplayground.di


import android.app.Application
import android.content.Context
import com.example.calculator.usecase.SumUseCase
import com.marcosholgado.core.ExpensiveObject
import com.marcosholgado.core.di.AppScope
import com.marcosholgado.core.di.FeatureScope
import com.sundevs.basecinemark.resource.StringsProvider
import dagger.Binds

import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Suppress("unused")
@Module
class CoreModule {

    @AppScope
    @Provides
    fun provideContext(application: Application): Context = application


    @Singleton
    @Provides
    fun provideExpensiveObject(): ExpensiveObject = ExpensiveObject()


    @Provides
    fun stringsProvider(context: Context) = StringsProvider(context)


    @Provides
    fun provideSumUseCase(stringsProvider: StringsProvider)= SumUseCase(stringsProvider)

}