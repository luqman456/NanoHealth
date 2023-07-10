package com.example.nanohealth.ui.main.activities

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.nanohealth.R
import com.example.nanohealth.databinding.ActivityMainBinding
import com.example.nanohealth.ui.base.BaseActivity
import com.example.nanohealth.ui.main.fragment.CartFragment
import com.example.nanohealth.ui.main.fragment.HomeFragment
import com.example.nanohealth.ui.main.fragment.LikeFragment
import com.example.nanohealth.ui.main.fragment.ProfileFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var homeFragment: HomeFragment
    private lateinit var cartFragment: CartFragment
    private lateinit var likeFragment: LikeFragment
    private lateinit var profileFragment: ProfileFragment
    private var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeFragment = HomeFragment()
        cartFragment = CartFragment()
        likeFragment = LikeFragment()
        profileFragment = ProfileFragment()

        dataBinding.bottomNavigation.setOnItemSelectedListener { item ->

            when (item.itemId) {
                R.id.home -> {
                    if (fragment != homeFragment) {
                        fragment = homeFragment
                    }
                }

                R.id.cart -> {
                    if (fragment != cartFragment)
                        fragment = cartFragment
                }

                R.id.like -> {
                    if (fragment != likeFragment)
                        fragment = likeFragment
                }

                R.id.profile -> {
                    if (fragment != profileFragment)
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


    }

    private fun featureNotAvailable() {
        dataBinding.bottomNavigation.selectedItemId = R.id.home
        showToast("This feature not available")
    }

    private fun openHomeFragment() {
//        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
//        transaction.replace(
//            R.id.frameLayout,
//            homeFragment
//        )
//        transaction.addToBackStack(null)
//        transaction.commit()

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, homeFragment)
            .disallowAddToBackStack().commit()

    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun onClick(v: View) {
    }
}