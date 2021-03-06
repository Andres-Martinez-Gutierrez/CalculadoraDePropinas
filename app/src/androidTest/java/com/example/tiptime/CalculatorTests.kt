package com.example.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTests {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculateNormallyPercentTip() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))

        onView(withId(R.id.calculate_button)).perform(scrollTo()).perform(click());

        onView(withId(R.id.tip_result))
          .check(matches(withText(containsString("$55.00"))))
    }

    @Test
    fun calculateAmazingPercenTip() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))

        onView(withId(R.id.option_twenty_percent)).perform(scrollTo()).perform(click())

        onView(withId(R.id.calculate_button)).perform(scrollTo()).perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$60.00"))))
    }

    @Test
    fun calculateGoodPercent_tip() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))

        onView(withId(R.id.option_eighteen_percent)).perform(scrollTo()).perform(click())

        onView(withId(R.id.calculate_button)).perform(scrollTo()).perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$59.00"))))
    }

    @Test
    fun calculateOkPercentTip() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))

        onView(withId(R.id.option_fifteen_percent)).perform(scrollTo()).perform(click())

        onView(withId(R.id.calculate_button)).perform(scrollTo()).perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$58.00"))))
    }

    @Test
    fun roundUpSwitch() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.25"))

        onView(withId(R.id.round_up_switch)).perform(scrollTo()).perform(click())

        onView(withId(R.id.calculate_button)).perform(scrollTo()).perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$55.28"))))
    }
}

