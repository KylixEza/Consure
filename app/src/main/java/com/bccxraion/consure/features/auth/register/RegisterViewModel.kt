package com.bccxraion.consure.features.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bccxraion.consure.data.source.local.datastore.ConsureDataStore
import com.bccxraion.consure.data.source.remote.api.service.ApiService
import com.bccxraion.consure.data.util.Resource
import com.bccxraion.consure.model.user.UserBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RegisterViewModel(
    private val apiService: ApiService,
    private val dataStore: ConsureDataStore
) : ViewModel() {
    
    fun signUp(body: UserBody) = flow {
        val response = apiService.signUp(body)
        if (response.isSuccess) {
            response.body?.let { dataStore.saveToken(it.token) }
            emit(Resource.Success(Unit))
        } else {
            emit(Resource.Error(response.message))
        }
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
        .asLiveData()
    
}