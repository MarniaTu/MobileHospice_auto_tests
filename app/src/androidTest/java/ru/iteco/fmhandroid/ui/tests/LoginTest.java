package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.LoginPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.utils.ToastMatcher;
import ru.iteco.fmhandroid.ui.utils.IntViewWaiter;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    private LoginPage loginPage;
    private MainPage mainPage;

    @Before

    public void setUp() {

        Espresso.onView(isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.enter_button, 5000));
        loginPage = new LoginPage();

        loginPage.checkAuthTextIsDisplayed();
        loginPage.checkAuthTextMatch();
    }

    @Test
    public void loginSuccessTest() {

        loginPage.checkLoginFieldIsDisplayed();
        loginPage.enterCorrectLogin();

        loginPage.checkPasswordFieldIsDisplayed();
        loginPage.enterCorrectPassword();

        loginPage.checkSignInButtonIsDisplayed();
        loginPage.clickSignInButton();

        Espresso.onView(isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.all_news_text_view, 3000));
        mainPage = new MainPage();

        mainPage.checkAllNewsTextIsDisplayed();
        mainPage.checkAllNewsTextMatch();

        mainPage.checkAuthorizationImageButtonIsDisplayed();
        mainPage.clickAuthorizationImageButton();

        mainPage.checkLogOutButtonMatch();
        mainPage.clickLogOutButton();

        loginPage.checkAuthTextIsDisplayed();
        loginPage.checkAuthTextMatch();
    }

    @Test
    public void loginEmptyFieldsTest() {

        loginPage.clickSignInButton();

        Espresso.onView(ViewMatchers.withText(R.string.empty_login_or_password)).inRoot(new ToastMatcher()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

    }

    @Test
    public void wrongLoginTest() {

        loginPage.checkLoginFieldIsDisplayed();
        loginPage.enterWrongLogin();

        loginPage.checkPasswordFieldIsDisplayed();
        loginPage.enterCorrectPassword();

        loginPage.checkSignInButtonIsDisplayed();
        loginPage.clickSignInButton();

        Espresso.onView(ViewMatchers.withText(R.string.wrong_login_or_password)).inRoot(new ToastMatcher()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

    }

}
