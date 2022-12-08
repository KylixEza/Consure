package com.bccxraion.consure.di

import com.bccxraion.consure.features.auth.login.LoginViewModel
import com.bccxraion.consure.features.auth.register.RegisterViewModel
import com.bccxraion.consure.features.book.payment_step.PaymentStepViewModel
import com.bccxraion.consure.features.book.schedule_step.ScheduleStepViewModel
import com.bccxraion.consure.features.booking_history.BookingHistoryViewModel
import com.bccxraion.consure.features.detail_find_expert.DetailFindExpertViewModel
import com.bccxraion.consure.features.find_expert.FindExpertViewModel
import com.bccxraion.consure.features.profile.ProfileViewModel
import com.bccxraion.consure.features.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { LoginViewModel(get(), get()) }
    viewModel { RegisterViewModel(get(), get()) }
    viewModel { FindExpertViewModel(get(), get()) }
    viewModel { DetailFindExpertViewModel(get(), get()) }
    viewModel { ScheduleStepViewModel(get(), get()) }
    viewModel { PaymentStepViewModel(get(), get()) }
    viewModel { ProfileViewModel(get(), get()) }
    viewModel { BookingHistoryViewModel(get(), get()) }
}