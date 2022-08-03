package com.cesor.android.couponsprueba1.mainModule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.cesor.android.couponsprueba1.BR
import com.cesor.android.couponsprueba1.R
import com.cesor.android.couponsprueba1.common.utils.hideKeyboard
import com.cesor.android.couponsprueba1.databinding.ActivityMainBinding
import com.cesor.android.couponsprueba1.mainModule.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupViewModel()
        setupObservers()
    }

    private fun setupViewModel() {
        val vm : MainViewModel by viewModels()
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, vm)
    }

    private fun setupObservers() {
        binding.viewModel?.let {
            it.coupon.observe(this@MainActivity){ coupon ->
                binding.isActive = coupon != null && coupon.isActive
            }
            it.getSnackBarMsg().observe(this@MainActivity){ msg ->
                Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).show()
            }
            it.isHideKeyboard().observe(this@MainActivity){ isHide ->
                if (isHide) hideKeyboard(this@MainActivity, binding.root)
            }
        }
    }
}