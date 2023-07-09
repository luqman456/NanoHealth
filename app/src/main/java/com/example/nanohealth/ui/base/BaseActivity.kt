package com.example.nanohealth.ui.base

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.nanohealth.ui.main.dialog.CustomProgressDialog
import com.example.nanohealth.ui.main.interfaces.OnClickHandler


abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity(), OnClickHandler {

    lateinit var dataBinding: DB
    lateinit var context: Context
    private var customProgressDialog: CustomProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, getLayoutResource())
        context = this
        customProgressDialog = CustomProgressDialog(context)
    }

    open fun showProgressDialog() {
        if (customProgressDialog?.isShowingProgress == false) {
            customProgressDialog?.showProgress()
        }
    }

    open fun showProgressDialogWithCustomText(msg: String?) {
        customProgressDialog?.showProgressWithCustomText(msg!!)
    }

    open fun dismissProgressDialog() {
        customProgressDialog?.dismiss()
    }


    protected abstract fun getLayoutResource(): Int

    fun show(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }


}