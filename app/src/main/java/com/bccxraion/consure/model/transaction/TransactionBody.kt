package com.bccxraion.consure.model.transaction

import com.google.gson.annotations.SerializedName

data class TransactionBody(
    @field:SerializedName("paket")
    val packageSelected: String,
    
    @field:SerializedName("jadwal")
    val schedule: String,
    
    @field:SerializedName("harga_paket")
    val packagePrice: Int,
    
    @field:SerializedName("total_beli")
    val totalBuy: Int,
    
    @field:SerializedName("id_expert")
    val expertId: Int,
)
