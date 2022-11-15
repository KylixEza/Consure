package com.bccxraion.consure.base

import com.bccxraion.consure.data.source.local.LocalAnswer
import com.bccxraion.consure.data.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class DatabaseOnlyResource<ResultType, RequestType> {

    private val flowResult = flow<Resource<ResultType>> {
        emit(Resource.Loading())
        when(val result = loadFromDb().first()) {
            is LocalAnswer.Success -> emit(Resource.Success(mapTransform(result.data)))
            is LocalAnswer.Error -> emit(Resource.Error(result.errorMessage))
            is LocalAnswer.Empty -> emit(Resource.Empty())
        }
    }.flowOn(Dispatchers.IO)

    abstract suspend fun loadFromDb(): Flow<LocalAnswer<RequestType>>
    abstract fun mapTransform(data: RequestType): ResultType

    fun asFlow() = flowResult

}