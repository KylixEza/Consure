package com.oreyo.foodie.base

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.oreyo.foodie.data.connectivity.ConnectivityStatus
import com.oreyo.foodie.data.connectivity.NetworkConnectivityObserver
import com.bccxraion.consure.data.source.local.LocalAnswer
import com.oreyo.foodie.data.source.remote.RemoteResponse
import com.oreyo.foodie.data.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

abstract class DatabaseBoundRequest<FromApi>(
    context: Context
) {
    
    private val connectivityManager = NetworkConnectivityObserver(context)
    
    @RequiresApi(Build.VERSION_CODES.N)
    private val result: Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        if(shouldFetch().first()) {
            saveToDatabase()
            when(val remoteResponse = uploadToServer().first()) {
                is RemoteResponse.Success -> emit(Resource.Success(Unit))
                is RemoteResponse.Error -> emit(Resource.Error(remoteResponse.errorMessage))
                else -> emit(Resource.Empty())
            }
        } else {
            emit(Resource.Error("No internet connection"))
        }
    }
    
    @RequiresApi(Build.VERSION_CODES.N)
    fun asFlow() = result
    
    abstract suspend fun uploadToServer(): Flow<RemoteResponse<FromApi>>
    abstract suspend fun saveToDatabase(): LocalAnswer<Unit>
    
    @RequiresApi(Build.VERSION_CODES.N)
    open suspend fun shouldFetch(): Flow<Boolean> = flow {
        var state = ConnectivityStatus.Unavailable
        connectivityManager.observe().collect {
            state = it
        }
        when(state) {
            ConnectivityStatus.Available -> emit(true)
            else -> emit(false)
        }
    }
    
}