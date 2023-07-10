package com.example.nanohealth.ui.main.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nanohealth.R
import com.example.nanohealth.data.models.Product
import com.example.nanohealth.data.models.ProductList
import com.example.nanohealth.databinding.FragmentHomeBinding
import com.example.nanohealth.ui.adapter.ProductAdapter
import com.example.nanohealth.ui.base.BaseFragment
import com.example.nanohealth.ui.main.activities.ProductDetailActivity
import com.example.nanohealth.ui.main.viewmodel.LoginViewModel
import com.example.nanohealth.ui.main.viewmodel.ProductViewModel
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private lateinit var productList: ArrayList<Product>
    private lateinit var productViewModel: ProductViewModel
    private var productAdapter: ProductAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productList = ArrayList()
        productViewModel = ViewModelProvider(requireActivity())[ProductViewModel::class.java]
    }

    override fun onClick(v: View) {

    }


    override fun OnCreateView(inflater: LayoutInflater?, savedInstanceState: Bundle?) {

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeRecycleView()

        productViewModel.shareProductList.observe(viewLifecycleOwner) {

            if (it == null) {
                dataBinding.recycleViewPro.visibility = View.GONE
                dataBinding.textViewTitle.visibility = View.VISIBLE
            } else {
                if (productList.size > 0) {
                    productList.clear()
                    productAdapter?.notifyDataSetChanged()
                }
                dataBinding.textViewTitle.visibility = View.GONE
                dataBinding.recycleViewPro.visibility = View.VISIBLE
                productList.addAll(it)
                productAdapter?.notifyDataSetChanged()


            }
        }


    }

    private fun initializeRecycleView() {
        val recyclerViewNews = dataBinding.recycleViewPro
        recyclerViewNews.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL, false
        )
        recyclerViewNews.setHasFixedSize(true)
        productAdapter = ProductAdapter(productList) { _id ->
            startActivity(
                Intent(requireActivity(), ProductDetailActivity::class.java)
                    .putExtra("id", _id)
            )
        }

        recyclerViewNews.adapter = productAdapter

    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_home
    }

}