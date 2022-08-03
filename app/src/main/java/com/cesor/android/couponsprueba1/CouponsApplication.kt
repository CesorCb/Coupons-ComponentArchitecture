package com.cesor.android.couponsprueba1

import android.app.Application
import androidx.room.Room
import com.cesor.android.couponsprueba1.common.dataAccess.CouponDatabase

/****
 * Project: CouponsPrueba1
 * From: com.cesor.android.couponsprueba1
 * Created by: César Castro on 28/07/2022 at 23:55.
 ***/
class CouponsApplication : Application() {
    companion object{
        lateinit var database: CouponDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this,
            CouponDatabase::class.java,
            "CouponDatabase").build()
    }
}