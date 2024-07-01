package br.edu.utfpr.money_fuel_save_calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CalculateInstrumentedTest {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        Espresso.onView(ViewMatchers.withId(R.id.fuel_one_input))
            .perform(ViewActions.typeText("15"))

        Espresso.onView(ViewMatchers.withId(R.id.fuel_two_input))
            .perform(ViewActions.typeText("10"))

        Espresso.onView(ViewMatchers.withId(R.id.price_one_input))
            .perform(ViewActions.typeText("154"))

        Espresso.onView(ViewMatchers.withId(R.id.price_two_input))
            .perform(ViewActions.typeText("126"))

        Espresso.onView(ViewMatchers.withId(R.id.calc_button))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.result_one))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("$10.27"))))

        Espresso.onView(ViewMatchers.withId(R.id.result_two))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("$12.60"))))

        Espresso.onView(ViewMatchers.withId(R.id.result_conclusion))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Combustível 1 é mais barata"))))
    }
}