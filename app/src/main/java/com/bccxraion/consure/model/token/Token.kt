package com.bccxraion.consure.model.token

import com.google.gson.annotations.SerializedName

data class Token(
    @field:SerializedName("token")
    val token: String
)
