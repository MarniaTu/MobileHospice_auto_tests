package ru.iteco.fmhandroid.ui.tests;


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
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.LoginPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.pages.OurMissionPage;
import ru.iteco.fmhandroid.ui.utils.IntViewWaiter;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AboutPageTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    private LoginPage loginPage;
    private MainPage mainPage;
    private AboutPage aboutPage;
    private NewsPage newsPage;
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

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.all_news_text_view, 3000));
        mainPage = new MainPage();

        mainPage.checkAllNewsTextIsDisplayed();
        mainPage.checkAllNewsTextMatch();

    }

    @After
    public void tearDown() {
        mainPage.checkAuthorizationImageButtonIsDisplayed();
        mainPage.clickAuthorizationImageButton();

        mainPage.checkLogOutButtonMatch();
        mainPage.clickLogOutButton();

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.enter_button, 3000));
        loginPage.checkAuthTextIsDisplayed();
        loginPage.checkAuthTextMatch();

    }


    @Test
    public void aboutPageFromMainPageTest() {

        mainPage.checkMainMenuButtonIsDisplayed();
        mainPage.clickMainMenuButton();

        mainPage.checkAboutMenuItemIsDisplayed();
        mainPage.clickAboutMenuItem();

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.about_version_title_text_view, 3000));
        aboutPage = new AboutPage();
        aboutPage.checkVersionTitleIsDisplayed();
        aboutPage.checkVersionTitleMatch();

        aboutPage.checkBackButtonIsDisplayed();
        aboutPage.clickBackButton();

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.all_news_text_view, 3000));
        mainPage.checkAllNewsTextIsDisplayed();
        mainPage.checkAllNewsTextMatch();

    }

    @Test
    public void aboutPageFromNewsPageTest() {

        mainPage.checkMainMenuButtonIsDisplayed();
        mainPage.clickMainMenuButton();

        mainPage.checkNewsMenuItemIsDisplayed();
        mainPage.clickNewsMenuItem();

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.edit_news_material_button, 3000));
        newsPage = new NewsPage();
        newsPage.checkEditNewsButtonIsDisplayed();

        mainPage.checkNewsMenuItemIsDisplayed();
        mainPage.clickNewsMenuItem();

        mainPage.checkAboutMenuItemIsDisplayed();
        mainPage.clickAboutMenuItem();

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.about_version_title_text_view, 3000));
        aboutPage = new AboutPage();
        aboutPage.checkVersionTitleIsDisplayed();
        aboutPage.checkVersionTitleMatch();

        aboutPage.checkBackButtonIsDisplayed();
        aboutPage.clickBackButton();

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.edit_news_material_button, 3000));
        newsPage.checkEditNewsButtonIsDisplayed();

    }

    @Test
    public void aboutPageFromOurMissionPageTest() {

        mainPage.checkOurMissionButtonIsDisplayed();
        mainPage.clickOurMissionButton();

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.our_mission_title_text_view, 3000));
        ourMissionPage = new OurMissionPage();
        ourMissionPage.checkOurMissionTitleIsDisplayed();
        ourMissionPage.checkOurMissionTitleMatch();

        mainPage.checkMainMenuButtonIsDisplayed();
        mainPage.clickMainMenuButton();

        mainPage.checkAboutMenuItemIsDisplayed();
        mainPage.clickAboutMenuItem();

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.about_version_title_text_view, 3000));
        aboutPage = new AboutPage();
        aboutPage.checkVersionTitleIsDisplayed();
        aboutPage.checkVersionTitleMatch();

        aboutPage.checkBackButtonIsDisplayed();
        aboutPage.clickBackButton();

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.our_mission_title_text_view, 3000));
        ourMissionPage.checkOurMissionTitleIsDisplayed();
        ourMissionPage.checkOurMissionTitleMatch();

    }

    @Test
    public void aboutPageFromControlPanelTest() {

        mainPage.checkMainMenuButtonIsDisplayed();
        mainPage.clickMainMenuButton();

        mainPage.checkNewsMenuItemIsDisplayed();
        mainPage.clickNewsMenuItem();

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.edit_news_material_button, 3000));
        newsPage = new NewsPage();
        newsPage.checkEditNewsButtonIsDisplayed();
        newsPage.clickEditNewsButton();

        newsPage.checkControlPanelTextIsDisplayed();
        newsPage.checkControlPanelTextMatch();

        mainPage.checkMainMenuButtonIsDisplayed();
        mainPage.clickMainMenuButton();

        mainPage.checkAboutMenuItemIsDisplayed();
        mainPage.clickAboutMenuItem();

        Espresso.onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.about_version_title_text_view, 3000));
        aboutPage = new AboutPage();
        aboutPage.checkVersionTitleIsDisplayed();
        aboutPage.checkVersionTitleMatch();

        aboutPage.checkBackButtonIsDisplayed();
        aboutPage.clickBackButton();

//        Espresso.onView(ViewMatchers.isRoot()).perform(ViewWaiter.waitDisplayed(R.id.edit_news_material_button, 3000));
        newsPage.checkControlPanelTextIsDisplayed();
        newsPage.checkControlPanelTextMatch();

    }

}
