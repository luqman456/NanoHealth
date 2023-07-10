package com.example.nanohealth.ui.main.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.nanohealth.R
import com.example.nanohealth.databinding.ActivityMainBinding
import com.example.nanohealth.ui.base.BaseActivity
import com.example.nanohealth.ui.main.fragment.CartFragment
import com.example.nanohealth.ui.main.fragment.HomeFragment
import com.example.nanohealth.ui.main.fragment.LikeFragment
import com.example.nanohealth.ui.main.fragment.ProfileFragment
import com.example.nanohealth.ui.main.viewmodel.ProductViewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var homeFragment: HomeFragment
    private lateinit var cartFragment: CartFragment
    private lateinit var likeFragment: LikeFragment
    private lateinit var profileFragment: ProfileFragment
    private var fragment: Fragment? = null
    private lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productViewModel = ViewModelProvider(this@MainActivity)[ProductViewModel::class.java]
        homeFragment = HomeFragment()
        cartFragment = CartFragment()
        likeFragment = LikeFragment()
        profileFragment = ProfileFragment()

        dataBinding.bottomNavigation.setOnItemSelectedListener { item ->

            when (item.itemId) {
                R.id.home -> {
                    fragment = homeFragment
                    if (!productViewModel.shareProductList.isInitialized) {
                        productViewModel.getProduct()
                    }
                }

                R.id.cart -> {
                    fragment = cartFragment
                }

                R.id.like -> {
                    fragment = likeFragment
                }

                R.id.profile -> {
                    fragment = profileFragment
                }
            }
            fragment?.let {
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, it)
                    .disallowAddToBackStack().commit()

            }
            true
        }
        dataBinding.bottomNavigation.selectedItemId = R.id.home
        openHomeFragment()


        productViewModel.apiError.observe(this) {
            showToast(it.toString())
        }

        productViewModel.loading.observe(this) {
            if (it == true) {
                showProgressDialogWithCustomText("Loading...")
            } else {
                dismissProgressDialog()
            }
        }

        productViewModel.apiCallException.observe(this) {
            dismissProgressDialog()
            showToast(it.exceptionMsg)
        }

        productViewModel.productList.observe(this) {

            it.let {
                productViewModel.sendMessage(it)
            }
        }

        productViewModel.getProduct()


    }

    private fun featureNotAvailable() {
        dataBinding.bottomNavigation.selectedItemId = R.id.home
        showToast("This feature not available")
    }

    private fun openHomeFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, homeFragment)
            .disallowAddToBackStack().commit()
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun onClick(v: View) {
    }
}