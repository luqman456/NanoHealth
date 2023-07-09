package com.example.nanohealth.ui.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.nanohealth.ui.main.dialog.CustomProgressDialog
import com.example.nanohealth.ui.main.interfaces.OnClickHandler

abstract class BaseFragment<DB : ViewDataBinding> : Fragment(), OnClickHandler {

    lateinit var dataBinding: DB
    private var customProgressDialog: CustomProgressDialog? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        OnCreateView(inflater, savedInstanceState)
        customProgressDialog = CustomProgressDialog(requireContext())
        return dataBinding.root
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


    abstract fun OnCreateView(inflater: LayoutInflater?, savedInstanceState: Bundle?)

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    fun show(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

}