package com.bccxraion.consure.model.history

import com.bccxraion.consure.model.expert.Expert
import com.bccxraion.consure.model.transaction.Transaction
import com.google.gson.annotations.SerializedName

data class History(
    @field:SerializedName("expert")
    val expert: Expert,
    
    @field:SerializedName("transactions")
    val transaction: Transaction,
)
