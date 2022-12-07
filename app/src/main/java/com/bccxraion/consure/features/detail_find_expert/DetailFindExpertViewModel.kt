package com.bccxraion.consure.features.detail_find_expert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bccxraion.consure.data.source.local.datastore.ConsureDataStore
import com.bccxraion.consure.data.source.remote.api.service.ApiService
import com.bccxraion.consure.data.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DetailFindExpertViewModel(
    private val apiService: ApiService,
    private val dataStore: ConsureDataStore
): ViewModel() {
    
    fun fetchExpertById(id: String) = flow {
        val token = dataStore.readToken().first() ?: ""
        val response = apiService.fetchExpertById(token, id)
        if (response.isSuccess) {
            emit(Resource.Success(response.body))
        } else {
            emit(Resource.Error(response.message))
        }
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
        .asLiveData()
    
}