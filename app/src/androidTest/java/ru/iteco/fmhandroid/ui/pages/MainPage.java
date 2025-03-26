package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.utils.ByIndexMatcher.withIndex;
import static ru.iteco.fmhandroid.ui.utils.CustomViewActions.waitForDisplayed;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testdata.TestData;

public class MainPage {

    private ViewInteraction getAllNewsText() {
        return onView(withId(R.id.all_news_text_view));
    }

    public void checkAllNewsTextIsDisplayed() {
        getAllNewsText().check(matches(isDisplayed()));
    }

    public void checkAllNewsTextMatch() {
        getAllNewsText().check(matches(withText("ALL NEWS")));
    }

    public void clickAllNewsText() {
        getAllNewsText().perform(click());
    }


    private ViewInteraction getAuthorizationImageButton() {
        return onView((withId(R.id.authorization_image_button)));
    }

    public void checkAuthorizationImageButtonIsDisplayed() {
        getAuthorizationImageButton().check(matches(isDisplayed()));
    }

    public void clickAuthorizationImageButton() {
        getAuthorizationImageButton().perform(click());
    }


    private ViewInteraction getLogOutButton() {
        return onView((withId(android.R.id.title)));
    }

    public void checkLogOutButtonMatch() {

        getLogOutButton().check(matches(withText("Log out")));
    }

    public void clickLogOutButton() {
        getLogOutButton().perform(click());
    }

    private ViewInteraction getMainMenuButton() {
        return onView(withId(R.id.main_menu_image_button));
    }

    public void checkMainMenuButtonIsDisplayed() {
        getMainMenuButton().check(matches(isDisplayed()));
    }

    public void clickMainMenuButton() {
        getMainMenuButton().perform(click());

    }

    private ViewInteraction getAboutMenuItem() {
        return onView(allOf(withId(android.R.id.title), withText("About"), childAtPosition(childAtPosition(withId(android.R.id.content), 0), 0), isDisplayed()));
    }

    public void checkAboutMenuItemIsDisplayed() {
        getAboutMenuItem().check(matches(isDisplayed()));
    }

    public void clickAboutMenuItem() {
        getAboutMenuItem().perform(click());
    }


    private ViewInteraction getNewsMenuItem() {
        return onView(allOf(withId(android.R.id.title), withText("News"), childAtPosition(childAtPosition(withId(android.R.id.content), 0), 0), isDisplayed()));
    }

    public void checkNewsMenuItemIsDisplayed() {
        getNewsMenuItem().check(matches(isDisplayed()));
    }

    public void clickNewsMenuItem() {
        getNewsMenuItem().perform(click());
    }


    private ViewInteraction getOurMissionButton() {
        return onView(withId(R.id.our_mission_image_button));
    }

    public void checkOurMissionButtonIsDisplayed() {
        getOurMissionButton().check(matches(isDisplayed()));
    }

    public void clickOurMissionButton() {
        getOurMissionButton().perform(click());
    }


    private static Matcher<View> childAtPosition(final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent) && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
