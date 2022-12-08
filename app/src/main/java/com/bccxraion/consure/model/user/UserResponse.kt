package com.bccxraion.consure.model.user

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @field:SerializedName("Username")
    val username: String,
    
    @field:SerializedName("Email")
    val email: String,
    
    @field:SerializedName("LinkImage")
    val linkImage: String,
)
