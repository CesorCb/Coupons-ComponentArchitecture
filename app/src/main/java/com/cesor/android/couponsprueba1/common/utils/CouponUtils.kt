package com.cesor.android.couponsprueba1.common.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.cesor.android.couponsprueba1.R

/****
 * Project: CouponsPrueba1
 * From: com.cesor.android.couponsprueba1.common.utils
 * Created by: César Castro on 29/07/2022 at 00:10.
 ***/

fun validateTextCode(code: String): Boolean{
    return !(code.length < 5 || code.length > 10)
}

fun getMsgErrorByCode(errorCode: String?): Int = when(errorCode){
    Constants.ERROR_LENGTH -> R.string.error_code_length
    Constants.ERROR_EXIST -> R.string.error_unique_code
    else -> R.string.error_code_unknown
}

fun hideKeyboard(context: Context, view: View){
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.hideSoftInputFromWindow(view.windowToken, 0)
}