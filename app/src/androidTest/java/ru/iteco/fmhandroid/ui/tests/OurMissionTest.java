package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

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
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.LoginPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.OurMissionPage;
import ru.iteco.fmhandroid.ui.utils.AllureScreenshotWatcher;
import ru.iteco.fmhandroid.ui.utils.RecyclerViewItemCountAssertion;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Feature("Проверки страницы с цитатами")
public class OurMissionTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public AllureScreenshotWatcher screenshotWatcher = new AllureScreenshotWatcher();

    private LoginPage loginPage;
    private MainPage mainPage;
    private OurMissionPage ourMissionPage;


    @Before

    public void setUp() {

        loginPage = new LoginPage();
        loginPage.waitUntilLoginScreenLoaded();
        mainPage = loginPage.performSuccessLogin();

        mainPage.checkOurMissionButtonIsDisplayed();
        mainPage.clickOurMissionButton();

        ourMissionPage = new OurMissionPage();
        ourMissionPage.waitOurMissionTitleIsDisplayed();

        ourMissionPage.checkOurMissionTitleIsDisplayed();
        ourMissionPage.checkOurMissionTitleMatch();

    }

    @After
    public void tearDown() {
        mainPage.performLogOut();

        loginPage.checkAuthTextIsDisplayed();
        loginPage.checkAuthTextMatch();

    }

    @Test
    @Story("Отображение и соответствие дополнительного текста первой цитаты")
    @Description("При нажатии на карточку с первой цитатой дополнительный текст отображается и соответствует ожидаемому")
    public void checkFirstDetailedTextTest() {

        onView(withId(R.id.our_mission_item_list_recycler_view)).perform(actionOnItemAtPosition(0, click()));

        ourMissionPage.checkFirstOurMissionCardTextIsDisplayed();
        ourMissionPage.checkFirstOurMissionCardTextExpectedMatch();


    }

    @Test
    @Story("Определение количества карточек с цитатами")
    @Description("На странице отображаются 8 карточек с цитатами")
    public void checkCardsNumberInListTest() {

        int expectedItemCount = 8;

        onView(withId(R.id.our_mission_item_list_recycler_view)).check(new RecyclerViewItemCountAssertion(expectedItemCount));


    }


}

