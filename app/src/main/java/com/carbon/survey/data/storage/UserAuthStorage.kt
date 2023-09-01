package com.carbon.survey.data.storage

import com.carbon.survey.domain.entity.UserAuthData

class UserAuthStorage : Storage<UserAuthData> {

    private var userData: UserAuthData = UserAuthData()

    override fun store(data: UserAuthData) {
        userData = data
    }

    override fun get(): UserAuthData {
        return userData
    }
}