package com.bccxraion.consure.features.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bccxraion.consure.data.source.local.datastore.ConsureDataStore
import com.bccxraion.consure.data.source.remote.api.service.ApiService
import com.bccxraion.consure.data.util.Resource
import com.bccxraion.consure.model.user.UserBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class LoginViewModel(
    private val apiService: ApiService,
    private val dataStore: ConsureDataStore
) : ViewModel() {
    
    fun signIn(body: UserBody) = flow {
        val response = apiService.signIn(body)
        if (response.isSuccess) {
            emit(Resource.Success(Unit))
            response.body.token.let { dataStore.saveToken(it) }
        } else {
           emit(Resource.Error(response.message))
        }
    }.catch {
       emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
        .asLiveData()
    
}