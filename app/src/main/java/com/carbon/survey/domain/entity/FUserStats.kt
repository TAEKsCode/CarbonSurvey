package com.carbon.survey.domain.entity

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class FUserStats(
    val androidLaunch: Long = 0,
    val otherSystemLaunch: Long = 0,
    val appOpenedCount: Long = 0
)