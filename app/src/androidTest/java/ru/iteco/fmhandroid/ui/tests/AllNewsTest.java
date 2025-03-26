package ru.iteco.fmhandroid.ui.tests;


import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.LoginPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.utils.IntViewWaiter;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AllNewsTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    private LoginPage loginPage;
    private MainPage mainPage;
    private NewsPage newsPage;


    @Test
    public void allNewsTest() {

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.enter_button, 5000));
        loginPage = new LoginPage();

        loginPage.checkAuthTextIsDisplayed();
        loginPage.checkAuthTextMatch();

        loginPage.checkLoginFieldIsDisplayed();
        loginPage.enterCorrectLogin();

        loginPage.checkPasswordFieldIsDisplayed();
        loginPage.enterCorrectPassword();

        loginPage.checkSignInButtonIsDisplayed();
        loginPage.clickSignInButton();


        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.all_news_text_view, 3000));
        mainPage = new MainPage();

        mainPage.checkAllNewsTextIsDisplayed();
        mainPage.checkAllNewsTextMatch();
        mainPage.clickAllNewsText();

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.filter_news_material_button, 3000));
        newsPage = new NewsPage();
        newsPage.checkFilterButtonIsDisplayed();

        mainPage.checkAuthorizationImageButtonIsDisplayed();
        mainPage.clickAuthorizationImageButton();

        mainPage.checkLogOutButtonMatch();
        mainPage.clickLogOutButton();

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.enter_button, 3000));
        loginPage.checkAuthTextIsDisplayed();
        loginPage.checkAuthTextMatch();
    }

}
