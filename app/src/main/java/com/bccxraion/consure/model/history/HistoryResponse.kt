package com.bccxraion.consure.model.history

import com.google.gson.annotations.SerializedName

data class HistoryResponse(
    @field:SerializedName("ID")
    val id: Int,

    @field:SerializedName("paket")
    val packageSelected: String,
    
)
