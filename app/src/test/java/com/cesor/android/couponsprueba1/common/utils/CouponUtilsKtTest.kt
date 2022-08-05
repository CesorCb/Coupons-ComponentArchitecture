package com.cesor.android.couponsprueba1.common.utils

import org.junit.Assert.*
import org.junit.Test
import com.cesor.android.couponsprueba1.R
import com.cesor.android.couponsprueba1.common.entities.CouponEntity

/****
 * Project: CouponsPrueba1
 * From: com.cesor.android.couponsprueba1.common.utils
 * Created by: César Castro on 3/08/2022 at 13:18.
 */
class CouponUtilsKtTest {
    @Test
    fun validateTextCodeSuccessTest() {
        val code = "Welcome"
        assertTrue(validateTextCode(code))
    }
    @Test
    fun validateTextCodeEmptyFailTest() {
        val code = ""
        assertFalse(validateTextCode(code))
    }
    @Test
    fun validateTextCodeMinLengthTest() {
        val code = "ola"
        val code2 = "olaola"
        assertFalse(validateTextCode(code))
        assertTrue(validateTextCode(code2))
    }
    @Test
    fun validateTextCodeMaxLengthTest() {
        val code = "olaolaolaolaolaola"
        val code2 = "olaola"
        assertFalse(validateTextCode(code))
        assertTrue(validateTextCode(code2))
    }
    @Test
    fun getMsgErrorByCodeNullTest(){
        val errorCode = null
        val expectedValue = R.string.error_code_unknown
        val result = getMsgErrorByCode(errorCode)
        assertEquals(expectedValue, result)
    }
    @Test
    fun getMsgErrorByCodeExistTest(){
        val errorCode = Constants.ERROR_EXIST
        val expectedValue = R.string.error_unique_code
        val result = getMsgErrorByCode(errorCode)
        assertEquals("Error al evaluar cupón ya existente", expectedValue, result)
    }
    @Test
    fun getMsgErrorByCodeLengthTest(){
        val errorCode = Constants.ERROR_LENGTH
        val expectedValue = R.string.error_code_length
        val result = getMsgErrorByCode(errorCode)
        assertEquals("Error al evaluar longitud de cupón", expectedValue, result)
        assertNotEquals("Error al evaluar longitud de cupón", -1, result)
    }
    @Test
    fun checkNotNullCouponTest(){
        val coupon = CouponEntity(code = "123456", description = "Clave wifi")
        assertNotNull("El cupón no debería ser null", coupon)
    }
    @Test
    fun checkGroupsSuccessTest(){
        val aNames = arrayOf("Carlos", "Kevin", "Junior")
        val bNames = arrayOf("Carlos", "Kevin", "Junior")
        assertArrayEquals("Los grupos deberían ser similares, revisa sus elementos.", bNames, aNames)
    }
    @Test fun checkGroupFallTest(){
        val aNames = arrayOf("Carlos", "Kevin", "Junior")
        val bNames = arrayOf("Carlos", "Kevin", "Junior")
        assertNotEquals("Los grupos no deberían ser iguales", bNames, aNames)
    }
}