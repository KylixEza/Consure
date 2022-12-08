package com.bccxraion.consure.data.source.remote.api.service

import com.bccxraion.consure.model.BaseResponse
import com.bccxraion.consure.model.expert.Expert
import com.bccxraion.consure.model.history.History
import com.bccxraion.consure.model.token.Token
import com.bccxraion.consure.model.transaction.TransactionBody
import com.bccxraion.consure.model.user.UserBody
import com.bccxraion.consure.model.user.UserResponse
import retrofit2.http.*

interface ApiService {

    @POST("/user/signup")
    suspend fun signUp(
        @Body body: UserBody,
    ): BaseResponse<Token>

    @POST("/user/signin")
    suspend fun signIn(
        @Body body: UserBody,
    ): BaseResponse<Token>
    
    @GET("/user/profile")
    suspend fun getProfile(
        @Header("Authorization") token: String,
    ): BaseResponse<UserResponse>
    
    @GET("/expert/all")
    suspend fun fetchAllExperts(
        @Header("Authorization") token: String
    ): BaseResponse<List<Expert>>
    
    @GET("/expert/search")
    suspend fun fetchExpertsByTag(
        @Header("Authorization") token: String,
        @Query("tag") tag: String
    ): BaseResponse<List<Expert>>
    
    @GET("/expert/single/{id}")
    suspend fun fetchExpertById(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): BaseResponse<Expert>
    
    @POST("/transaction")
    suspend fun createTransaction(
        @Header("Authorization") token: String,
        @Body body: TransactionBody
    ): BaseResponse<String?>
    
    @GET("/transaction/history")
    suspend fun fetchHistory(
        @Header("Authorization") token: String,
        @Query("status") status: String
    ): BaseResponse<List<History>>
    
}