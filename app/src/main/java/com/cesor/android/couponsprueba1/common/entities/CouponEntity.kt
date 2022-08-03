package com.cesor.android.couponsprueba1.common.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/****
 * Project: CouponsPrueba1
 * From: com.cesor.android.couponsprueba1
 * Created by: César Castro on 28/07/2022 at 23:35.
 ***/
@Entity(tableName = "CouponEntity", indices = [Index(value = ["code"], unique = true)])
data class CouponEntity(@PrimaryKey(autoGenerate = true) var id: Long = 0,
                        var code: String = "",
                        var description: String = "",
                        var isActive: Boolean = true)
