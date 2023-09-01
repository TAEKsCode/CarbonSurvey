package com.carbon.survey.ui.stats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carbon.survey.data.FirebaseActivityManager
import com.carbon.survey.domain.entity.FAppStats
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue

class StatsViewModel(
    private val activityManager: FirebaseActivityManager
) : ViewModel() {

    val stats = MutableLiveData<FAppStats>()

    init {
        collectStats()
    }

    fun trackResultsOpened() {
        activityManager.trackResultsOpened()
    }

    private fun collectStats() {
        activityManager.collectStats(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.getValue<FAppStats>() ?: return
                stats.value = data
            }

            override fun onCancelled(error: DatabaseError) {
                // display error
            }
        })
    }
}