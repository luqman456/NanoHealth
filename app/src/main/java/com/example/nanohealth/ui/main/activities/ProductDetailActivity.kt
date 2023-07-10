package com.example.nanohealth.ui.main.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.nanohealth.R
import com.example.nanohealth.databinding.ActivityProductDetailBinding
import com.example.nanohealth.ui.base.BaseActivity
import com.example.nanohealth.ui.main.viewmodel.ProductViewModel
import com.example.nanohealth.utilities.ImageUtil

class ProductDetailActivity : BaseActivity<ActivityProductDetailBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding.clickHandler = this
        val productViewModel =
            ViewModelProvider(this@ProductDetailActivity)[ProductViewModel::class.java]

        productViewModel.getProductDetail(intent.getIntExtra("id", 0))

        productViewModel.apiError.observe(this@ProductDetailActivity) {
            showToast(it.toString())
        }

        productViewModel.loading.observe(this@ProductDetailActivity) {
            if (it == true) {
                showProgressDialogWithCustomText("Loading...")
            } else {
                dismissProgressDialog()
            }
        }

        productViewModel.apiCallException.observe(this@ProductDetailActivity) {
            dismissProgressDialog()
            showToast(it.exceptionMsg)
        }

        productViewModel.productDetails.observe(this@ProductDetailActivity) {
            it?.let {
                dataBinding.product = it
                ImageUtil.loadImage(dataBinding.ivPro, it.image)
                dataBinding.ratingBar.rating = it.rating?.rate?.toFloat() ?: 0f

            }
        }

    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_product_detail
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.ivUpDwon -> {
                if (dataBinding.group.visibility == View.VISIBLE) {
                    dataBinding.group.visibility = View.GONE
                    dataBinding.ivUpDwon.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_arrow_down
                        )
                    )
                } else {
                    dataBinding.group.visibility = View.VISIBLE
                    dataBinding.ivUpDwon.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_arrow_up
                        )
                    )
                }
            }
            R.id.viewBackPress -> {
                finish()
            }
            R.id.viewMore -> {
                showToast("This option not available")
            }
            R.id.viewShare -> {
                showToast("This option not available")
            }
            R.id.btnOrderNow -> {
                showToast("This option not available")
            }
        }
    }
}