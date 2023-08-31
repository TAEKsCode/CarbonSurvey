package com.carbon.survey.component.firebase

import android.content.Context
import androidx.startup.Initializer

class FirebaseInitializer : Initializer<FirebaseDependency> {
    override fun create(context: Context): FirebaseDependency {
        return FirebaseDependency(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}