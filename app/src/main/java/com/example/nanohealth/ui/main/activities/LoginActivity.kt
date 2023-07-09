package com.example.nanohealth.ui.main.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.nanohealth.R
import com.example.nanohealth.databinding.ActivityLoginBinding
import com.example.nanohealth.ui.base.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding.clickHandler = this

    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_login
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnContinue -> {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }

        }
    }
}