package com.carbon.survey.domain.entity

data class UserAuthData(
    val login: String = UNAUTHORIZED_LOGIN
) {
    companion object {
        const val UNAUTHORIZED_LOGIN = "unauthorized"
    }
}