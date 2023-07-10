package com.example.nanohealth.ui.main.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.nanohealth.R
import com.example.nanohealth.databinding.ActivityLoginBinding
import com.example.nanohealth.retrofit.RetrofitCleintNew
import com.example.nanohealth.ui.base.BaseActivity
import com.example.nanohealth.ui.main.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding.clickHandler = this
        RetrofitCleintNew().clearRetrofit()
        loginViewModel =
            ViewModelProvider(this@LoginActivity)[LoginViewModel::class.java]

        loginViewModel.apiError.observe(this@LoginActivity) {
            showToast(it.toString())
        }

        loginViewModel.loading.observe(this@LoginActivity) {
            if (it == true) {
                showProgressDialogWithCustomText("Processing...")
            } else {
                dismissProgressDialog()
            }
        }

        loginViewModel.apiCallException.observe(this@LoginActivity) {
            dismissProgressDialog()
            showToast(it.exceptionMsg)
        }

        loginViewModel.loginResponse.observe(this@LoginActivity) {
            it?.let {
               startActivity(Intent(this@LoginActivity,MainActivity::class.java))
               finish()
            }
        }


    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_login
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnContinue -> {
                loginViewModel.sendLongRequest(dataBinding.editTextEmail.text.toString().trim(),dataBinding.editTextPassword.text.toString().trim())
            }

        }
    }
}