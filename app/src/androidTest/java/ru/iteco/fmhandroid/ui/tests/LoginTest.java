package ru.iteco.fmhandroid.ui.tests;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
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
import ru.iteco.fmhandroid.ui.utils.AllureScreenshotWatcher;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Feature("Авторизация")

public class LoginTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public AllureScreenshotWatcher screenshotWatcher = new AllureScreenshotWatcher();

    private LoginPage loginPage;
    private MainPage mainPage;


    @Before
    public void setUp() {

        loginPage = new LoginPage();
        loginPage.waitUntilLoginScreenLoaded();
    }

    @Test
    @Story("Успешная авторизация")
    @Description("При вводе валидного логина и пароля пользователь может авторизоваться")
    public void loginSuccessTest() {

        mainPage = loginPage.performSuccessLogin();

        mainPage.checkAllNewsTextIsDisplayed();
        mainPage.checkAllNewsTextMatch();

        mainPage.performLogOut();

        loginPage.checkAuthTextIsDisplayed();
        loginPage.checkAuthTextMatch();
    }

    @Test
    @Story("Попытка авторизации с незаполненными полями")
    @Description("Пользователь не может авторизоваться с незаполнеными полями логина и пароля")
    public void loginEmptyFieldsTest() {


        loginPage.checkSignInButtonIsDisplayed();
        loginPage.clickSignInButton();

        loginPage.emptyFieldWarning();

    }

    @Test
    @Story("Попытка авторизации с невалидным логином")
    @Description("Пользователь не может авторизоваться с невалидным логином")
    public void wrongLoginTest() {

        loginPage.checkLoginFieldIsDisplayed();
        loginPage.enterWrongLogin();

        loginPage.checkPasswordFieldIsDisplayed();
        loginPage.enterCorrectPassword();

        loginPage.checkSignInButtonIsDisplayed();
        loginPage.clickSignInButton();

        loginPage.wrongLoginOrPasswordWarning();


    }

}
