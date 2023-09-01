package com.carbon.survey.di

import com.carbon.survey.data.FirebaseActivityManager
import com.carbon.survey.data.storage.UserAuthStorage
import com.carbon.survey.ui.login.LoginViewModel
import com.carbon.survey.ui.stats.StatsViewModel
import com.carbon.survey.ui.vote.VoteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val mainModule = module {

    viewModelOf(::StatsViewModel)

    viewModel { LoginViewModel(get(), get()) }
    viewModel { VoteViewModel(get()) }

    single { UserAuthStorage() }
    single { FirebaseActivityManager(get(), get()) }
}