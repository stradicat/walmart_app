<<<<<<<< HEAD:app/src/androidTest/java/com/example/shoppingapp/ExampleInstrumentedTest.kt
package com.example.shoppingapp
|||||||| parent of b81d7fe (App: nombre de proyecto modificado a genérico):app/src/androidTest/java/com/example/walmartapp/ExampleInstrumentedTest.kt
package com.example.walmartapp
========
package dev.dmayr.shoppingapp
>>>>>>>> b81d7fe (App: nombre de proyecto modificado a genérico):app/src/androidTest/java/dev/dmayr/shoppingapp/ExampleInstrumentedTest.kt

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.walmartapp", appContext.packageName)
    }
}
