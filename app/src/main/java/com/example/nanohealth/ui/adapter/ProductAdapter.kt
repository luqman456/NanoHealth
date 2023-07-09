package com.example.nanohealth.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nanohealth.data.models.Product
import com.example.nanohealth.databinding.ProductListBinding
import com.example.nanohealth.utilities.ImageUtil

class ProductAdapter(
    var productList: ArrayList<Product>, var clickEvent: (Int) -> Unit

) : RecyclerView.Adapter<ProductViewHolder>() {

    private lateinit var binding: ProductListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        binding =
            ProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val products = productList[position]
        holder.bind(products, clickEvent)
    }

    override fun getItemCount(): Int = productList.size

}

class ProductViewHolder(
    private val binding: ProductListBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(product: Product, clickEvent: (Int) -> Unit) {
        binding.product = product
        binding.ratingBar.rating = product.rating?.rate?.toFloat() ?: 0f
        ImageUtil.loadImage(binding.imageView, product.image)
    }

}