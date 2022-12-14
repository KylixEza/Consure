package com.bccxraion.consure.features.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bccxraion.consure.data.source.local.datastore.ConsureDataStore
import com.bccxraion.consure.data.source.remote.api.service.ApiService
import com.bccxraion.consure.data.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val apiService: ApiService,
    private val dataStore: ConsureDataStore
) : ViewModel() {
    
    fun getProfile() = flow {
        val token = dataStore.readToken().first() ?: ""
        val response = apiService.getProfile(token)
        if (response.isSuccess) {
            emit(Resource.Success(response.body))
        } else {
            emit(Resource.Error(response.message))
        }
    }.catch {
        emit(Resource.Error(it.message))
    }.flowOn(Dispatchers.IO)
        .asLiveData()
    
    fun fetchScheduledSchedule() = flow {
        val token = dataStore.readToken().first() ?: ""
        val response = apiService.fetchHistory(token, "scheduled")
        if (response.isSuccess) {
            if (response.body?.isNotEmpty() == true) {
                emit(Resource.Success(response.body))
            } else {
                emit(Resource.Empty())
            }
        } else {
            emit(Resource.Error(response.message))
        }
    }.catch {
        emit(Resource.Error(it.message))
    }.flowOn(Dispatchers.IO)
        .asLiveData()
    
    fun removeToken() = viewModelScope.launch {
        dataStore.deleteToken()
    }
}