package com.example.nanohealth.ui.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.nanohealth.ui.main.interfaces.OnClickHandler

abstract class BaseFragment<DB : ViewDataBinding> : Fragment(), OnClickHandler {

    lateinit var dataBinding: DB


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        OnCreateView(inflater, savedInstanceState)
        return dataBinding.root
    }


    abstract fun OnCreateView(inflater: LayoutInflater?, savedInstanceState: Bundle?)

    @LayoutRes
    protected abstract fun getLayoutRes(): Int


}