package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;

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
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.LoginPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.testdata.TestData;
import ru.iteco.fmhandroid.ui.utils.IntViewWaiter;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AddNewsTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    private LoginPage loginPage;
    private MainPage mainPage;
    private NewsPage newsPage;


    @Test
    public void addNewsTest() {
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

        Espresso.onView(isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.edit_news_material_button, 3000));
        newsPage = new NewsPage();

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

        newsPage.checkDateFieldIsDisplayed();
        newsPage.enterNewDate();

        newsPage.checkTimeFieldIsDisplayed();
        newsPage.enterNewTime();

        newsPage.checkNewNewsDescriptionFieldIsDisplayed();
        newsPage.enterNewNewsDescription();

        newsPage.checkChangeSaveButtonIsDisplayed();
        newsPage.clickChangeSaveButton();

        newsPage.checkFirstNewsCardIsDisplayed();
        newsPage.clickFirstNewsCard();

        newsPage.checkNewCardDescriptionIsDisplayed();
        newsPage.checkNewCardDescriptionMatch();

        mainPage.checkAuthorizationImageButtonIsDisplayed();
        mainPage.clickAuthorizationImageButton();

        mainPage.checkLogOutButtonMatch();
        mainPage.clickLogOutButton();

        Espresso.onView(isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.enter_button, 3000));
        loginPage.checkAuthTextIsDisplayed();
        loginPage.checkAuthTextMatch();
    }

}
