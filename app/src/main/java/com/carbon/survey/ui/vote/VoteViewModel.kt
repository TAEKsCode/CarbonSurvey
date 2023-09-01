package com.carbon.survey.ui.vote

import androidx.lifecycle.ViewModel
import com.carbon.survey.component.core.SingleLiveEvent
import com.carbon.survey.data.FirebaseActivityManager

class VoteViewModel(
    private val activityManager: FirebaseActivityManager
) : ViewModel() {

    val textEvent = SingleLiveEvent<String>()

    fun trackVoteOpened() {
        activityManager.trackVoteOpened()
    }

    fun vote(rating: Float) {
        activityManager.trackVoteSubmitted(rating)
    }

    fun removeAllUserdata() {
        activityManager.removeUserdata {
            textEvent.value = it
        }
    }
}