package ru.iteco.fmhandroid.ui.tests;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.LoginPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.pages.OurMissionPage;
import ru.iteco.fmhandroid.ui.utils.AllureScreenshotWatcher;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Feature("Навигация на страницу About")
public class AboutPageTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public AllureScreenshotWatcher screenshotWatcher = new AllureScreenshotWatcher();

    private LoginPage loginPage;
    private MainPage mainPage;
    private AboutPage aboutPage;
    private NewsPage newsPage;
    private OurMissionPage ourMissionPage;


    @Before

    public void setUp() {

        loginPage = new LoginPage();
        loginPage.waitUntilLoginScreenLoaded();
        mainPage = loginPage.performSuccessLogin();

        mainPage.checkAllNewsTextIsDisplayed();
        mainPage.checkAllNewsTextMatch();

    }

    @After
    public void tearDown() {

        mainPage.performLogOut();
        loginPage.checkAuthTextIsDisplayed();
        loginPage.checkAuthTextMatch();

    }


    @Test
    @Story("Переход на страницу About с главной страницы")
    @Description("Предусмотрен функционал перехода с главной страницы на страницу About")
    public void aboutPageFromMainPageTest() {

        mainPage.checkMainMenuButtonIsDisplayed();
        mainPage.clickMainMenuButton();

        mainPage.checkAboutMenuItemIsDisplayed();
        mainPage.clickAboutMenuItem();

        aboutPage = new AboutPage();
        aboutPage.waitVersionTitleIsDisplayed();
        aboutPage.checkVersionTitleIsDisplayed();
        aboutPage.checkVersionTitleMatch();

        aboutPage.checkBackButtonIsDisplayed();
        aboutPage.clickBackButton();

        mainPage.waitAllNewsTextIsDisplayed();
        mainPage.checkAllNewsTextIsDisplayed();
        mainPage.checkAllNewsTextMatch();

    }

    @Test
    @Story("Переход на страницу About со страницы новостей")
    @Description("Предусмотрен функционал перехода со страницы новостей на страницу About")
    public void aboutPageFromNewsPageTest() {

        mainPage.checkMainMenuButtonIsDisplayed();
        mainPage.clickMainMenuButton();

        mainPage.checkNewsMenuItemIsDisplayed();
        mainPage.clickNewsMenuItem();

        newsPage = new NewsPage();
        newsPage.waitEditNewsButtonIsDisplayed();
        newsPage.checkEditNewsButtonIsDisplayed();

        mainPage.checkNewsMenuItemIsDisplayed();
        mainPage.clickNewsMenuItem();

        mainPage.checkAboutMenuItemIsDisplayed();
        mainPage.clickAboutMenuItem();

        aboutPage = new AboutPage();
        aboutPage.waitVersionTitleIsDisplayed();
        aboutPage.checkVersionTitleIsDisplayed();
        aboutPage.checkVersionTitleMatch();

        aboutPage.checkBackButtonIsDisplayed();
        aboutPage.clickBackButton();

        newsPage.waitEditNewsButtonIsDisplayed();
        newsPage.checkEditNewsButtonIsDisplayed();

    }

    @Test
    @Story("Переход на страницу About со страницы с цитатами")
    @Description("Предусмотрен функционал перехода со страницы с цитатами на страницу About")
    public void aboutPageFromOurMissionPageTest() {

        mainPage.checkOurMissionButtonIsDisplayed();
        mainPage.clickOurMissionButton();

        ourMissionPage = new OurMissionPage();
        ourMissionPage.waitOurMissionTitleIsDisplayed();
        ourMissionPage.checkOurMissionTitleIsDisplayed();
        ourMissionPage.checkOurMissionTitleMatch();

        mainPage.checkMainMenuButtonIsDisplayed();
        mainPage.clickMainMenuButton();

        mainPage.checkAboutMenuItemIsDisplayed();
        mainPage.clickAboutMenuItem();

        aboutPage = new AboutPage();
        aboutPage.waitVersionTitleIsDisplayed();
        aboutPage.checkVersionTitleIsDisplayed();
        aboutPage.checkVersionTitleMatch();

        aboutPage.checkBackButtonIsDisplayed();
        aboutPage.clickBackButton();

        ourMissionPage.waitOurMissionTitleIsDisplayed();

        ourMissionPage.checkOurMissionTitleIsDisplayed();
        ourMissionPage.checkOurMissionTitleMatch();

    }

    @Test
    @Story("Переход на страницу About из контрольной панели")
    @Description("Предусмотрен функционал перехода из контрольной панели на страницу About")
    public void aboutPageFromControlPanelTest() {

        mainPage.checkMainMenuButtonIsDisplayed();
        mainPage.clickMainMenuButton();

        mainPage.checkNewsMenuItemIsDisplayed();
        mainPage.clickNewsMenuItem();

        newsPage = new NewsPage();
        newsPage.waitEditNewsButtonIsDisplayed();

        newsPage.checkEditNewsButtonIsDisplayed();
        newsPage.clickEditNewsButton();

        newsPage.checkControlPanelTextIsDisplayed();
        newsPage.checkControlPanelTextMatch();

        mainPage.checkMainMenuButtonIsDisplayed();
        mainPage.clickMainMenuButton();

        mainPage.checkAboutMenuItemIsDisplayed();
        mainPage.clickAboutMenuItem();

        aboutPage = new AboutPage();
        aboutPage.waitVersionTitleIsDisplayed();

        aboutPage.checkVersionTitleIsDisplayed();
        aboutPage.checkVersionTitleMatch();

        aboutPage.checkBackButtonIsDisplayed();
        aboutPage.clickBackButton();

        newsPage.checkControlPanelTextIsDisplayed();
        newsPage.checkControlPanelTextMatch();

    }

}
