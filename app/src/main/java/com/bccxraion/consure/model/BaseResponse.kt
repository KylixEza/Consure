package com.bccxraion.consure.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T> (
    @field:SerializedName("success")
    val isSuccess: Boolean,
    
    @field:SerializedName("message")
    val message: String,
    
    @field:SerializedName("body")
    val body: T,
    
    @field:SerializedName("status_code")
    val statusCode: Int
)