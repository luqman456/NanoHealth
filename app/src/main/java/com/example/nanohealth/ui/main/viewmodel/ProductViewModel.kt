package com.example.nanohealth.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.nanohealth.data.models.LoginResponse
import com.example.nanohealth.data.models.Product
import com.example.nanohealth.data.models.ProductList
import com.example.nanohealth.data.repository.ProductListRepository
import com.example.nanohealth.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductViewModel constructor(
    application: Application
) : BaseViewModel(application) {

    private val productRepository = ProductListRepository()
    val productList = MutableLiveData<List<Product>>()
    val productDetails = MutableLiveData<Product>()


    fun getProduct() {
        loading.value = true
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = productRepository.getProduct()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    loading.postValue(false)
                    productList.postValue(response.body())
                } else {
                    loading.postValue(false)
                    apiError.postValue(response.message())
                }
            }
        }

    }

    fun getProductDetail(id: Int) {
        loading.value = true
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = productRepository.getProductDetails(id)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    loading.postValue(false)
                    productDetails.postValue(response.body())
                } else {
                    loading.postValue(false)
                    apiError.postValue(response.message())
                }
            }
        }

    }


}