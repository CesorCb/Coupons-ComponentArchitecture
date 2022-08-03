package com.cesor.android.couponsprueba1.common.dataAccess

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cesor.android.couponsprueba1.common.entities.CouponEntity

/****
 * Project: CouponsPrueba1
 * From: com.cesor.android.couponsprueba1
 * Created by: César Castro on 28/07/2022 at 23:52.
 ***/
@Database(entities = [CouponEntity::class], version = 1)
abstract class CouponDatabase : RoomDatabase(){
    abstract fun couponDao(): CouponDao
}