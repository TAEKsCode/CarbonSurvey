package com.carbon.survey.data

import android.content.Context
import com.carbon.survey.data.DatabaseStructure.APP_LEVEL
import com.carbon.survey.data.DatabaseStructure.LOGIN_COUNT
import com.carbon.survey.data.DatabaseStructure.AVERAGE_RATING
import com.carbon.survey.data.DatabaseStructure.RATINGS_SUBMITTED
import com.carbon.survey.data.DatabaseStructure.RESULTS_OPENED
import com.carbon.survey.data.DatabaseStructure.USER_LEVEL
import com.carbon.survey.data.DatabaseStructure.VOTE_OPENED
import com.carbon.survey.data.storage.UserAuthStorage
import com.carbon.survey.domain.entity.FAppStats
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ServerValue
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class FirebaseActivityManager(
    private val context: Context,
    private val userAuthStorage: UserAuthStorage
) {

    private val database =
        Firebase.database.reference

    fun trackLogin() {
        user().child(LOGIN_COUNT).setValue(ServerValue.increment(1))
    }

    fun trackVoteSubmitted(rating: Float) {
        appLevel().get()
            .addOnSuccessListener { snapshot ->
                val data = snapshot.getValue<FAppStats>() ?: return@addOnSuccessListener
                val totalCount = data.ratingsSubmitted * data.averageRating
                val newAvg = (totalCount + rating) / (data.ratingsSubmitted + 1)

                val changes = mapOf(
                    AVERAGE_RATING to newAvg,
                    RATINGS_SUBMITTED to ServerValue.increment(1)
                )

                appLevel().updateChildren(changes)
            }
    }

    fun trackResultsOpened() {
        appLevel().child(RESULTS_OPENED).setValue(ServerValue.increment(1))
    }

    fun trackVoteOpened() {
        appLevel().child(VOTE_OPENED).setValue(ServerValue.increment(1))
    }

    fun removeUserdata(callback: (String) -> Unit) {
        user().removeValue().addOnSuccessListener {
            callback("Successfully removed all userdata")
        }.addOnFailureListener {
            callback("Oops, please try again")
        }
    }

    fun collectStats(listener: ValueEventListener) {
        appLevel().addValueEventListener(listener)
    }

    private fun appLevel(): DatabaseReference = database.child(APP_LEVEL)

    private fun user() = database.child(USER_LEVEL).child(md5(userAuthStorage.get().login))

    private fun md5(string: String): String {
        val hash: ByteArray = try {
            MessageDigest.getInstance("MD5").digest(string.toByteArray(StandardCharsets.UTF_8))
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException("Huh, MD5 should be supported?", e)
        }
        val hex = StringBuilder(hash.size * 2)
        for (b in hash) {
            val i = b.toInt() and 0xFF
            if (i < 0x10) hex.append('0')
            hex.append(Integer.toHexString(i))
        }
        return hex.toString()
    }
}