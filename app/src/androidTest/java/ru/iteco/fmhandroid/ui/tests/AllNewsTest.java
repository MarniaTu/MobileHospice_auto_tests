package ru.iteco.fmhandroid.ui.tests;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.LoginPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.utils.AllureScreenshotWatcher;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Feature("Переход на экран всех новостей")
public class AllNewsTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public AllureScreenshotWatcher screenshotWatcher = new AllureScreenshotWatcher();

    private LoginPage loginPage;
    private MainPage mainPage;
    private NewsPage newsPage;


    @Test
    @Story("Успешный переход на экран всех новостей")
    @Description("При нажатии на главной странице кнопки AllNews пользователь переходит на экран всех опубликованных новостей")
    public void allNewsTest() {

        loginPage = new LoginPage();
        loginPage.waitUntilLoginScreenLoaded();
        mainPage = loginPage.performSuccessLogin();

        mainPage.checkAllNewsTextIsDisplayed();
        mainPage.checkAllNewsTextMatch();
        mainPage.clickAllNewsText();

        newsPage = new NewsPage();
        newsPage.waitFilterButtonIsDisplayed();
        newsPage.checkFilterButtonIsDisplayed();

        mainPage.performLogOut();
        loginPage.checkAuthTextIsDisplayed();
        loginPage.checkAuthTextMatch();
    }

}
