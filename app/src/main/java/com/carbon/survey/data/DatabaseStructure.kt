package com.carbon.survey.data

/*
{
appLevel:{
  averageRating,
  ratingsSubmitted,
  resultsOpened,
  voteOpened
},
userLevel:[
    login: {
        androidLaunch,
        otherSystemLaunch,
        loginCount
}
}
*/
object DatabaseStructure {
    const val APP_LEVEL = "appLevel"
    const val AVERAGE_RATING = "averageRating"
    const val RATINGS_SUBMITTED = "ratingsSubmitted"
    const val RESULTS_OPENED = "resultsOpened"
    const val VOTE_OPENED = "voteOpened"
    const val USER_LEVEL = "userLevel"
    const val ANDROID_LAUNCH = "androidLaunch"
    const val OTHER_SYSTEM_LAUNCH = "otherSystemLaunch"
    const val LOGIN_COUNT = "loginCount"
}