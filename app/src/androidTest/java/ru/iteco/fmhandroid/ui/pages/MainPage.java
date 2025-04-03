package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.utils.IntViewWaiter;

public class MainPage {


    public void checkAllNewsTextIsDisplayed() {

        Allure.step("Проверка отображения текста AllNews");
        onView(withId(R.id.all_news_text_view)).check(matches(isDisplayed()));
    }

    public void checkAllNewsTextMatch() {

        Allure.step("Проверка соответствия отображенного текста AllNews");
        onView(withId(R.id.all_news_text_view)).check(matches(withText("ALL NEWS")));
    }

    public void clickAllNewsText() {

        Allure.step("Клик по тексту AllNews");
        onView(withId(R.id.all_news_text_view)).perform(click());
    }


    public void checkAuthorizationImageButtonIsDisplayed() {

        Allure.step("Проверка отображения иконки личного кабинета");
        onView((withId(R.id.authorization_image_button))).check(matches(isDisplayed()));
    }

    public void clickAuthorizationImageButton() {

        Allure.step("Нажатие на иконку личного кабинета");
        onView((withId(R.id.authorization_image_button))).perform(click());
    }


    public void checkLogOutButtonMatch() {

        Allure.step("Проверка отображения кнопки выхода из личного кабинета");
        onView((withId(android.R.id.title))).check(matches(withText("Log out")));
    }

    public void clickLogOutButton() {

        Allure.step("Нажатие на кнопку выхода из личного кабинета");
        onView((withId(android.R.id.title))).perform(click());
    }


    public void checkMainMenuButtonIsDisplayed() {

        Allure.step("Проверка отображения иконки главного меню");
        onView(withId(R.id.main_menu_image_button)).check(matches(isDisplayed()));
    }

    public void clickMainMenuButton() {

        Allure.step("Нажатие на иконку главного меню");
        onView(withId(R.id.main_menu_image_button)).perform(click());

    }


    public void checkAboutMenuItemIsDisplayed() {

        Allure.step("Проверка отображения пункта меню About");
        onView(allOf(withId(android.R.id.title), withText("About"), childAtPosition(childAtPosition(withId(android.R.id.content), 0), 0), isDisplayed())).check(matches(isDisplayed()));
    }

    public void clickAboutMenuItem() {

        Allure.step("Нажатие на пункт меню About");
        onView(allOf(withId(android.R.id.title), withText("About"), childAtPosition(childAtPosition(withId(android.R.id.content), 0), 0), isDisplayed())).perform(click());
    }


    public void checkNewsMenuItemIsDisplayed() {

        Allure.step("Проверка отображения пункта меню News");
        onView(allOf(withId(android.R.id.title), withText("News"), childAtPosition(childAtPosition(withId(android.R.id.content), 0), 0), isDisplayed())).check(matches(isDisplayed()));
    }

    public void clickNewsMenuItem() {

        Allure.step("Нажатие на пункт меню News");
        onView(allOf(withId(android.R.id.title), withText("News"), childAtPosition(childAtPosition(withId(android.R.id.content), 0), 0), isDisplayed())).perform(click());
    }


    public void checkOurMissionButtonIsDisplayed() {

        Allure.step("Проверка отображения иконки OurMission");
        onView(withId(R.id.our_mission_image_button)).check(matches(isDisplayed()));
    }

    public void clickOurMissionButton() {

        Allure.step("Нажатие на иконку OurMission");
        onView(withId(R.id.our_mission_image_button)).perform(click());
    }

    public LoginPage performLogOut() {
        checkAuthorizationImageButtonIsDisplayed();
        clickAuthorizationImageButton();

        checkLogOutButtonMatch();
        clickLogOutButton();

        return new LoginPage();
    }


    public void waitAllNewsTextIsDisplayed() {
        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.all_news_text_view, 3000));

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
