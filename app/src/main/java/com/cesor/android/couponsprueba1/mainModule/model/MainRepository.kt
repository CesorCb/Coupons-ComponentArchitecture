package com.cesor.android.couponsprueba1.mainModule.model

import com.cesor.android.couponsprueba1.common.entities.CouponEntity
import com.cesor.android.couponsprueba1.common.utils.Constants
import com.cesor.android.couponsprueba1.common.utils.validateTextCode

/****
 * Project: CouponsPrueba1
 * From: com.cesor.android.couponsprueba1.mainModule.model
 * Created by: César Castro on 29/07/2022 at 00:11.
 ***/
class MainRepository {

    private val couponsLocalDataSource = CouponsLocalDataSource()

    suspend fun consultCouponByCode(code: String) = couponsLocalDataSource.consultCouponByCode(code)

    suspend fun saveCoupon(couponEntity: CouponEntity){
        if (validateTextCode(couponEntity.code)){
            couponsLocalDataSource.saveCoupon(couponEntity)
        } else {
            throw Exception(Constants.ERROR_LENGTH)
        }
    }
}