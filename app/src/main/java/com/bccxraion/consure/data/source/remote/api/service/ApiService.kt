package com.bccxraion.consure.data.source.remote.api.service

import com.bccxraion.consure.model.BaseResponse
import com.bccxraion.consure.model.expert.Expert
import com.bccxraion.consure.model.token.Token
import com.bccxraion.consure.model.user.UserBody
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
    
}