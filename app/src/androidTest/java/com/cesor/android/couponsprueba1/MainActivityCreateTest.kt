package com.cesor.android.couponsprueba1

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.cesor.android.couponsprueba1.mainModule.view.MainActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/****
 * Project: CouponsPrueba1
 * From: com.cesor.android.couponsprueba1
 * Created by: César Castro on 3/08/2022 at 22:53.
 ***/

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityCreateTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun createCouponTest(){
        val etCoupon = onView(withId(R.id.etCoupon))
        etCoupon.check(matches(withText(""))) //Compara la vista con el texto ""
        etCoupon.perform(click())
        etCoupon.perform(replaceText("COUPON_03"))

        val btnConsult = onView(withId(R.id.btnConsult))
        btnConsult.perform(click())

        val btnCreate = onView(withId(R.id.btnCreate))
        btnCreate.check(matches(isDisplayed()))

        val etDescription = onView(withId(R.id.etDescription))
        etDescription.perform(click())
        etDescription.perform(replaceText("Cupon de bienvenida"))

        btnCreate.perform(click())

        val snackBarMsg = onView(withId(com.google.android.material.R.id.snackbar_text))
        snackBarMsg.check(matches(withText("Cupón creado")))
    }

    /*
    * Verificar que el btnCreate no existe y no es visible
    * Test: etCoupon inicia vacío, se hace click sobre él y se le añade el texto "COUPON_01"
    * luego se hace click en btnConsult
    * Finalmente se verifica que el btnCreate no sea visible
    * */
    @Test
    fun consultCouponExistTest(){
        val etCoupon = onView(withId(R.id.etCoupon))
        etCoupon.check(matches(withText(""))) //Compara la vista con el texto ""
        etCoupon.perform(click())
        etCoupon.perform(replaceText("COUPON_03"))

        val btnConsult = onView(withId(R.id.btnConsult))
        btnConsult.perform(click())

        val btnCreate = onView(withId(R.id.btnCreate))
        btnCreate.check(matches(not((isDisplayed()))))
    }

    /*
    * Comprobar que no se puede crear cupón con código repetido
    * etCoupon inicia vacío y se le reemplaza el texto por uno nuevo("COUPON_04")
    * luego se hace click en btnConsult
    * Se corrobora que btnCreate exista
    * Se añade descripción y se edita etCoupon por uno ya existente
    * se hace click en btnCreate
    * Se comprueba que el el snackBarMsg muestre el mensaje
    *  ("Este cupón ya existe, agrega uno diferente")
    * */
    @Test

    fun consultCouponWithOldCodeTest(){
        val etCoupon = onView(withId(R.id.etCoupon))
        etCoupon.check(matches(withText("")))
        etCoupon.perform(click())
        etCoupon.perform(replaceText("COUPON_04"))

        val btnConsult = onView(withId(R.id.btnConsult))
        btnConsult.perform(click())

        val btnCreate = onView(withId(R.id.btnCreate))
        btnCreate.check(matches((isDisplayed())))

        val etDescription = onView(withId(R.id.etDescription))
        etDescription.perform(click())
        etDescription.perform(replaceText("Cupon de bienvenidaHolaaa"))

        etCoupon.perform(replaceText("COUPON_01"))

        btnCreate.perform(click())

        val snackBarMsg = onView(withId(com.google.android.material.R.id.snackbar_text))
        snackBarMsg.check(matches(withText("Este cupón ya existe, agrega uno diferente")))
    }
}