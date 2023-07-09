package com.example.nanohealth.data.models

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id") var id: Int = 0, @SerializedName("title") var title: String? = null,
    @SerializedName("price") var price: Double = 0.0,
    @SerializedName("description") var description: String? = null,
    @SerializedName("category") var category: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("rating") var rating: Rating? = null
)