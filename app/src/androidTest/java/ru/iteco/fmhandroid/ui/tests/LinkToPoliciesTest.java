package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;

import android.content.Intent;

import androidx.test.espresso.intent.Intents;
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
import ru.iteco.fmhandroid.ui.testdata.TestData;
import ru.iteco.fmhandroid.ui.utils.AllureScreenshotWatcher;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Feature("Переходы по ссылкам к пользовательским документам")
public class LinkToPoliciesTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public AllureScreenshotWatcher screenshotWatcher = new AllureScreenshotWatcher();

    private LoginPage loginPage;
    private MainPage mainPage;
    private AboutPage aboutPage;

    @Before

    public void setUp() {

        loginPage = new LoginPage();
        loginPage.waitUntilLoginScreenLoaded();
        mainPage = loginPage.performSuccessLogin();

        mainPage.checkAllNewsTextIsDisplayed();
        mainPage.checkAllNewsTextMatch();

        mainPage.checkMainMenuButtonIsDisplayed();
        mainPage.clickMainMenuButton();

        mainPage.checkAboutMenuItemIsDisplayed();
        mainPage.clickAboutMenuItem();


        Intents.init();

        aboutPage = new AboutPage();
        aboutPage.waitVersionTitleIsDisplayed();

    }

    @After
    public void tearDown() {
        mainPage.performLogOut();

        loginPage.checkAuthTextIsDisplayed();
        loginPage.checkAuthTextMatch();

    }


    @Test
    @Story("Переход по ссылке на политику конфиденциальности")
    @Description("При нажатии ссылки на политику конфиденциальности пользователь может перейти на страницу с документом политики")
    public void linkToPrivacyPolicyTest() {

        aboutPage.checkPrivacyPolicyLabelIsDisplayed();
        aboutPage.checkPrivacyPolicyLabelMatch();

        aboutPage.checkPrivacyPolicyLinkTextIsDisplayed();
        aboutPage.checkPrivacyPolicyLinkTextMatch();
        aboutPage.clickPrivacyPolicyLinkText();

        intended(hasData(TestData.PRIVACY_POLICY_LINK_TEXT));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();

    }

    @Test
    @Story("Переход по ссылке на пользовательское соглашение")
    @Description("При нажатии ссылки на пользовательское соглашение пользователь может перейти на страницу с документом соглашения")
    public void linkToTermsOfUseTest() {

        aboutPage.checkTermsOfUseLabelIsDisplayed();
        aboutPage.checkTermsOfUseLabelMatch();

        aboutPage.checkTermsOfUseLinkTextIsDisplayed();
        aboutPage.checkTermsOfUseLinkTextMatch();
        aboutPage.clickTermsOfUseLinkText();

        intended(hasData(TestData.TERMS_OF_USE_LINK_TEXT));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();

    }

}
