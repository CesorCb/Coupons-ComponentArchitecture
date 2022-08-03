package com.cesor.android.couponsprueba1.common.dataAccess

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cesor.android.couponsprueba1.common.entities.CouponEntity

/****
 * Project: CouponsPrueba1
 * From: com.cesor.android.couponsprueba1
 * Created by: César Castro on 28/07/2022 at 23:41.
 ***/
@Dao
interface CouponDao {
    @Query("SELECT * FROM CouponEntity WHERE code = :code")
    suspend fun consultCouponById(code: String) : CouponEntity?

    @Insert
    suspend fun addCoupon(couponEntity: CouponEntity) : Long
}