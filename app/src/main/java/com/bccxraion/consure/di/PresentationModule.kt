package com.bccxraion.consure.di

import com.bccxraion.consure.features.auth.login.LoginViewModel
import com.bccxraion.consure.features.find_expert.FindExpertViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get(), get()) }
    viewModel { FindExpertViewModel(get(), get()) }
}