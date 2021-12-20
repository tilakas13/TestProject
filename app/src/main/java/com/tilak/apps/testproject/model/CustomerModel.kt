package com.tilak.apps.testproject.model

import com.google.gson.annotations.SerializedName

data class CustomerModel(
    @SerializedName("name")
    val customerName: String,
    @SerializedName("city")
    val cityName: String,
    @SerializedName("image")
    val imageUrl: String
)
