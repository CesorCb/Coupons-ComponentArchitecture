package com.cesor.android.couponsprueba1.mainModule.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesor.android.couponsprueba1.R
import com.cesor.android.couponsprueba1.common.entities.CouponEntity
import com.cesor.android.couponsprueba1.common.utils.getMsgErrorByCode
import com.cesor.android.couponsprueba1.mainModule.model.MainRepository
import kotlinx.coroutines.launch

/****
 * Project: CouponsPrueba1
 * From: com.cesor.android.couponsprueba1.mainModule.viewModel
 * Created by: César Castro on 29/07/2022 at 00:15.
 ***/
class MainViewModel : ViewModel() {

    private val repository = MainRepository()

    val coupon = MutableLiveData(CouponEntity())

    private val hideKeyboard = MutableLiveData<Boolean>()
    fun isHideKeyboard() = hideKeyboard

    private val snackBarMsg = MutableLiveData<Int>()
    fun getSnackBarMsg() = snackBarMsg


    fun consultCouponByCode(){
        coupon.value?.code?.let { code ->
            viewModelScope.launch {
                hideKeyboard.value = true
                coupon.value = repository.consultCouponByCode(code) ?: CouponEntity(code = code, isActive = false)
            }
        }
    }

    fun saveCoupon(){
        coupon.value?.let { couponEntity ->
            viewModelScope.launch {
                hideKeyboard.value = true
                try {
                    couponEntity.isActive = true
                    repository.saveCoupon(couponEntity)
                    consultCouponByCode()
                    snackBarMsg.value = R.string.main_save_success
                } catch (e: Exception) {
                    snackBarMsg.value = getMsgErrorByCode(e.message)
                }
            }
        }
    }
}