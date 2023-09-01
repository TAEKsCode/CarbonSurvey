package com.carbon.survey.component.firebase

import android.content.Context
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class FirebaseDependency(context: Context) {

    init {
        Firebase.initialize(context)
    }
}