package com.bccxraion.consure.model.expert

import com.google.gson.annotations.SerializedName

data class Expert(
    @SerializedName("ID")
    val id: String,
    
    @SerializedName("nama")
    val name: String,
    
    @SerializedName("tag")
    val tag: String,
    
    @SerializedName("price")
    val price: Int,
    
    @SerializedName("experience")
    val experience: String,
    
    @SerializedName("link_image")
    val linkImage: String
)
