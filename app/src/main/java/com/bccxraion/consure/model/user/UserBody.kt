package com.bccxraion.consure.model.user

import com.google.gson.annotations.SerializedName

data class UserBody(
    @field:SerializedName("username")
    val username: String = "",
    
    @field:SerializedName("password")
    val password: String = "",
    
    @field:SerializedName("email")
    val email: String = "",
)
