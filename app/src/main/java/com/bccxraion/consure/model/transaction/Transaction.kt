package com.bccxraion.consure.model.transaction

import com.google.gson.annotations.SerializedName

data class Transaction(
    @field:SerializedName("ID")
    val id: String,
    
    @field:SerializedName("jadwal")
    val schedule: String,
    
    @field:SerializedName("total_harga")
    val totalPrice: Int,
    
    @field:SerializedName("status")
    val status: String,
)
