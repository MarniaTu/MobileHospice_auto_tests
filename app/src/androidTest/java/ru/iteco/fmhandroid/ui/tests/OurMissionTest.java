package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.LoginPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.OurMissionPage;
import ru.iteco.fmhandroid.ui.utils.IntViewWaiter;
import ru.iteco.fmhandroid.ui.utils.RecyclerViewItemCountAssertion;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class OurMissionTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    private LoginPage loginPage;
    private MainPage mainPage;
    private OurMissionPage ourMissionPage;


    @Before

    public void setUp() {

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

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.our_mission_image_button, 5000));

        mainPage = new MainPage();
        mainPage.checkOurMissionButtonIsDisplayed();
        mainPage.clickOurMissionButton();

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.our_mission_title_text_view, 5000));
        ourMissionPage = new OurMissionPage();

        ourMissionPage.checkOurMissionTitleIsDisplayed();
        ourMissionPage.checkOurMissionTitleMatch();

    }

    @After
    public void tearDown() {
        mainPage.checkAuthorizationImageButtonIsDisplayed();
        mainPage.clickAuthorizationImageButton();

        mainPage.checkLogOutButtonMatch();
        mainPage.clickLogOutButton();

        Espresso.onView(isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.enter_button, 3000));
        loginPage.checkAuthTextIsDisplayed();
        loginPage.checkAuthTextMatch();

    }

    @Test
    public void checkFirstDetailedTextTest() {

        onView(withId(R.id.our_mission_item_list_recycler_view)).perform(actionOnItemAtPosition(0, click()));

        ourMissionPage.checkFirstOurMissionCardTextIsDisplayed();
        ourMissionPage.checkFirstOurMissionCardTextExpectedMatch();


    }

    @Test
    public void checkCardsNumberInListTest() {

        int expectedItemCount = 8;

        onView(withId(R.id.our_mission_item_list_recycler_view)).check(new RecyclerViewItemCountAssertion(expectedItemCount));


    }


}

