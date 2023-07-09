package com.example.nanohealth.ui.main.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.widget.ProgressBar
import android.widget.TextView
import com.example.nanohealth.R
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window

class CustomProgressDialog(private val context: Context) {
    private var mDialog: Dialog?
    private val mProgressBar: ProgressBar
    private val textView: TextView

    init {
        mDialog = Dialog(context)
        mDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mDialog!!.setContentView(R.layout.custom_progress_dialog)
        mDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mProgressBar = mDialog!!.findViewById<View>(R.id.progressBar) as ProgressBar
        textView = mDialog!!.findViewById(R.id.textView)
    }

    fun showProgress() {
        mProgressBar.visibility = View.VISIBLE
        mProgressBar.isIndeterminate = true
        mDialog!!.setCancelable(false)
        mDialog!!.show()
    }

    fun showProgressWithCustomText(text: String) {
        textView.text = text
        mProgressBar.visibility = View.VISIBLE
        mProgressBar.isIndeterminate = true
        mDialog!!.setCancelable(false)
        if (text.isEmpty()) {
            textView.visibility = View.GONE
        }
        mDialog!!.show()
    }

    fun dismiss() {
        if (mDialog != null && mDialog!!.isShowing) {
            mProgressBar.visibility = View.GONE
            mDialog!!.dismiss()
        }
    }

    val isShowingProgress: Boolean
        get() = mDialog?.isShowing == true

    fun clearDialog() {
        mDialog = null
    }
}