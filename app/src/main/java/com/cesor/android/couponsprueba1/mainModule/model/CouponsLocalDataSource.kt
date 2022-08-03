package com.cesor.android.couponsprueba1.mainModule.model

import android.database.sqlite.SQLiteConstraintException
import com.cesor.android.couponsprueba1.CouponsApplication
import com.cesor.android.couponsprueba1.common.dataAccess.CouponDao
import com.cesor.android.couponsprueba1.common.entities.CouponEntity
import com.cesor.android.couponsprueba1.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/****
 * Project: CouponsPrueba1
 * From: com.cesor.android.couponsprueba1.mainModule.model
 * Created by: César Castro on 29/07/2022 at 00:14.
 ***/
class CouponsLocalDataSource {
    //Room database
    private val dao: CouponDao by lazy { CouponsApplication.database.couponDao() }

    suspend fun consultCouponByCode(code:String) = dao.consultCouponById(code)

    suspend fun saveCoupon(couponEntity: CouponEntity) = withContext(Dispatchers.IO){
        try {
            dao.addCoupon(couponEntity)
        } catch (e:Exception){
            (e as? SQLiteConstraintException)?.let { throw Exception(Constants.ERROR_EXIST) }
            throw Exception(e.message ?: Constants.ERROR_UNKNOWN)
        }
    }
}