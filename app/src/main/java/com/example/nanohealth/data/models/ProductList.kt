package com.example.nanohealth.data.models

import com.google.gson.annotations.SerializedName

data class ProductList(@SerializedName("Product") var list:  List<Product>? = null)
