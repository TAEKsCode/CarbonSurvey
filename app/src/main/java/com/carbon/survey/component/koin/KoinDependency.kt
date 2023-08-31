package com.carbon.survey.component.koin

import android.content.Context
import com.carbon.survey.di.KoinLoader

class KoinDependency(private val context: Context) {
    init {
        initialize()
    }

    private fun initialize() {
        KoinLoader.load(context)
    }
}