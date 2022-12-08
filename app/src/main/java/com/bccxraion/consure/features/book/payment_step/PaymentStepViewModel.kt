package com.bccxraion.consure.features.book.payment_step

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bccxraion.consure.data.source.local.datastore.ConsureDataStore
import com.bccxraion.consure.data.source.remote.api.service.ApiService
import com.bccxraion.consure.data.util.Resource
import com.bccxraion.consure.model.transaction.TransactionBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PaymentStepViewModel(
    private val apiService: ApiService,
    private val dataStore: ConsureDataStore
) : ViewModel() {
    
    fun createTransaction(body: TransactionBody) = flow {
        val token = dataStore.readToken().first() ?: ""
        val response = apiService.createTransaction(token, body)
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