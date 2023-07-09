package com.example.nanohealth.ui.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.nanohealth.ui.main.interfaces.OnClickHandler


abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity(), OnClickHandler {

    lateinit var dataBinding: DB
    lateinit var context: Context
    var progressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, getLayoutResource())
        context = this
    }




    fun showProgressDialog() {
        progressDialog?.show()
    }

    fun dismissDialog() {
        progressDialog?.dismiss()
    }

    protected abstract fun getLayoutResource(): Int

    fun show(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }


}