package com.bccxraion.consure.features.splash

import androidx.lifecycle.ViewModel
import com.bccxraion.consure.data.source.local.datastore.ConsureDataStore

class SplashViewModel(
    private val dataStore: ConsureDataStore
): ViewModel() {
    
    fun isRememberMe() = dataStore.readIsRememberMe()
    fun getToken() = dataStore.readToken()
    
}