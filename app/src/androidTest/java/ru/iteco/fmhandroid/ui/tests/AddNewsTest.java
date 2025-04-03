package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;

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
import ru.iteco.fmhandroid.ui.testdata.TestData;
import ru.iteco.fmhandroid.ui.utils.AllureScreenshotWatcher;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Feature("Добавление новостей")
public class AddNewsTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public AllureScreenshotWatcher screenshotWatcher = new AllureScreenshotWatcher();

    private LoginPage loginPage;
    private MainPage mainPage;
    private NewsPage newsPage;


    @Test
    @Story("Успешное добавление новости")
    @Description("При заполнении всех полей пользователь добавляет новость")
    public void addNewsTest() {

        loginPage = new LoginPage();
        loginPage.waitUntilLoginScreenLoaded();
        mainPage = loginPage.performSuccessLogin();

        mainPage.checkAllNewsTextIsDisplayed();
        mainPage.checkAllNewsTextMatch();
        mainPage.clickAllNewsText();

        newsPage = new NewsPage();
        newsPage.waitEditNewsButtonIsDisplayed();

        newsPage.checkEditNewsButtonIsDisplayed();
        newsPage.clickEditNewsButton();

        newsPage.checkAddNewsButtonIsDisplayed();
        newsPage.clickAddNewsButton();

        newsPage.checkDropDownButtonIsDisplayed();
        newsPage.clickDropDownButton();

        onView(withClassName(is("android.widget.PopupWindow$PopupBackgroundView")))
                .inRoot(isPlatformPopup())
                .check(matches(isDisplayed()));

        onView(withText(TestData.CATEGORY_TEXT))
                .inRoot(isPlatformPopup())
                .perform(click());

        newsPage.checkNewsTitleIsDisplayed();
        newsPage.enterNewsTitle();


        newsPage.checkDateFieldIsDisplayed();
        newsPage.enterNewDate();

        newsPage.checkTimeFieldIsDisplayed();
        newsPage.enterNewTime();

        newsPage.checkNewsDescriptionFieldIsDisplayed();
        newsPage.enterNewNewsDescription();

        newsPage.checkChangeSaveButtonIsDisplayed();
        newsPage.clickChangeSaveButton();

        newsPage.scrollDownNewsList();
        newsPage.checkAddedNewsTitleIsDisplayed();

        mainPage.performLogOut();

        loginPage.checkAuthTextIsDisplayed();
        loginPage.checkAuthTextMatch();
    }

}
