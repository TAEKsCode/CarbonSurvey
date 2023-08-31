package com.carbon.survey.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

object KoinLoader {
    fun load(application: Context) {
        val moduleList = listOf(mainModule)

        startKoin {
            androidContext(application)
            modules(moduleList)
        }
    }
}