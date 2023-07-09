package com.example.nanohealth.ui.main.activities

import android.os.Bundle
import android.view.View
import com.example.nanohealth.R
import com.example.nanohealth.databinding.ActivityMainBinding
import com.example.nanohealth.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding.bottomNavigation.setOnItemSelectedListener { item ->
//            if (item.itemId === R.id.home) {
//                if (fragment !== homeFragment) {
//                    fragment = homeFragment
//                }
//            } else if (item.itemId === R.id.calendar) {
//                if (fragment !== calendarFragment) {
//                    fragment = calendarFragment
//                }
//            } else if (item.itemId === R.id.instruction) {
//                if (fragment !== instructionFragment) {
//                    fragment = instructionFragment
//                }
//            } else if (item.itemId === R.id.profile) {
//                if (fragment !== profileFragment) {
//                    fragment = profileFragment
//                }
//            }
//            if (fragment != null) {
//                fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment)
//                    .commit()
//            }
            true
        }
        dataBinding.bottomNavigation.selectedItemId = R.id.home
//        setDefaultFragment()


    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun onClick(v: View) {
    }
}