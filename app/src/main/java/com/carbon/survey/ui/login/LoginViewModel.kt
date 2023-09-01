package com.carbon.survey.ui.login

import androidx.lifecycle.ViewModel
import com.carbon.survey.data.FirebaseActivityManager
import com.carbon.survey.data.storage.UserAuthStorage
import com.carbon.survey.domain.entity.UserAuthData

class LoginViewModel(
    private val authStorage: UserAuthStorage,
    private val activityManager: FirebaseActivityManager
) : ViewModel() {

    fun login(login: String) {
        authStorage.store(
            if (login.isNotEmpty()) {
                UserAuthData(login)
            } else {
                UserAuthData()
            }
        )

        activityManager.trackLogin()
    }
}