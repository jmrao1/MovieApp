package com.movies.movieapp;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringContains.containsString;

@RunWith(AndroidJUnit4.class)
public class MovieSearchTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void callingTests(){
        testObjectDisplayed();
        testMovieTitles();
        testMovieTitleID();
        testMovieSeries();
    }
    // test to check the elements in the screen are displayed
    private void testObjectDisplayed() {
        onView(withId(R.id.movie_name)).check(matches(isDisplayed()));
        onView(withId(R.id.seriesBtn)).check(matches(isDisplayed()));
        onView(withId(R.id.titleIdBtn)).check(matches(isDisplayed()));
        onView(withId(R.id.titleBtn)).check(matches(isDisplayed()));
    }

    // test to check the navigation on the screen for title button
    private void testMovieTitles()
    {
        onView(withId(R.id.movie_name)).perform(typeText("spy"));
        onView(withId(R.id.titleBtn)).perform(click());
        onView(withId(R.id.movie_name)).perform(clearText());
        onView(withId(R.id.resultView)).check(matches(withText(containsString("Title: Spy"))));

    }

    // test to check the navigation on the screen for title_id button
    private void testMovieTitleID()
    {
        onView(withId(R.id.movie_name)).perform(typeText("tt0094791"));
        onView(withId(R.id.titleIdBtn)).perform(click());
        onView(withId(R.id.movie_name)).perform(clearText());
        onView(withId(R.id.resultView)).check(matches(withText(containsString("Title: The Bourne Identity"))));

    }

    // test to check the navigation on the screen for series button
    private void testMovieSeries()
    {
        onView(withId(R.id.movie_name)).perform(typeText("tommorow"));
        onView(withId(R.id.seriesBtn)).perform(click());
        onView(withId(R.id.movie_name)).perform(clearText());
        onView(withId(R.id.resultView)).check(matches(withText(containsString("Title: For Today, for Tommorow"))));

    }

}
