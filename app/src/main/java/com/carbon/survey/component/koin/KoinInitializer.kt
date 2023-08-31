package com.carbon.survey.component.koin

import android.content.Context
import androidx.startup.Initializer

class KoinInitializer : Initializer<KoinDependency> {
    override fun create(context: Context): KoinDependency {
        return KoinDependency(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = listOf()
}