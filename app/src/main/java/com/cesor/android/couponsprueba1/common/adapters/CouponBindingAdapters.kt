package com.cesor.android.couponsprueba1.common.adapters

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.cesor.android.couponsprueba1.R

/****
 * Project: CouponsPrueba1
 * From: com.cesor.android.couponsprueba1.common.adapters
 * Created by: César Castro on 29/07/2022 at 00:10.
 ***/

    @BindingAdapter("isGone")
    fun bindIsGone(view: View, isGone: Boolean){
        view.visibility = if (isGone) View.GONE else View.VISIBLE
    }
    @BindingAdapter("titleChange")
    fun bindTitleChange(view: TextView, isActive: Boolean){
        if (isActive){
            view.setText(R.string.main_text_title)
            view.setTextColor(Color.BLACK)
        } else {
            view.setText(R.string.main_text_title_change)
            view.setTextColor(Color.MAGENTA)
        }
    }