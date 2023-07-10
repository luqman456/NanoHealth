package com.example.nanohealth.data.repository

import com.example.nanohealth.ui.NanoHealth

class ProductListRepository {

    suspend fun getProduct() =
        NanoHealth.getRetrofitClient().getProductList()

    suspend fun getProductDetails(id: Int) =
        NanoHealth.getRetrofitClient().getProductDetails(id)
}