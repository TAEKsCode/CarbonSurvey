package com.carbon.survey.domain.entity

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class FAppStats(
    val averageRating: Float = 0f,
    val ratingsSubmitted: Long = 0,
    val resultsOpened: Long = 0,
    val voteOpened: Long = 0
)