package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
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
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.utils.IntViewWaiter;
import ru.iteco.fmhandroid.ui.utils.RecyclerViewItemCountAssertion;
import ru.iteco.fmhandroid.ui.utils.ToastMatcher;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EditNewsTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    private LoginPage loginPage;
    private MainPage mainPage;
    private NewsPage newsPage;


    @Before

    public void setUp() {

        Espresso.onView(isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.enter_button, 5000));
        loginPage = new LoginPage();

        loginPage.checkAuthTextIsDisplayed();
        loginPage.checkAuthTextMatch();

        loginPage.checkLoginFieldIsDisplayed();
        loginPage.enterCorrectLogin();

        loginPage.checkPasswordFieldIsDisplayed();
        loginPage.enterCorrectPassword();

        loginPage.checkSignInButtonIsDisplayed();
        loginPage.clickSignInButton();

        Espresso.onView(isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.all_news_text_view, 3000));
        mainPage = new MainPage();

        mainPage.checkAllNewsTextIsDisplayed();
        mainPage.checkAllNewsTextMatch();

        mainPage.checkMainMenuButtonIsDisplayed();
        mainPage.clickMainMenuButton();

        mainPage.checkNewsMenuItemIsDisplayed();
        mainPage.clickNewsMenuItem();

        Espresso.onView(isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.edit_news_material_button, 3000));
        newsPage = new NewsPage();
        newsPage.checkEditNewsButtonIsDisplayed();
        newsPage.clickEditNewsButton();

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
    public void changeDescriptionTest() {

        newsPage.checkFirstNewsEditButtonIsDisplayed();
        newsPage.clickFirstNewsEditButton();

        newsPage.checkFirstNewsDescriptionFieldIsDisplayed();
        newsPage.clickFirstNewsDescriptionField();
        newsPage.enterNewDescription();

        newsPage.checkChangeSaveButtonIsDisplayed();
        newsPage.clickChangeSaveButton();

        newsPage.checkFirstNewsCardIsDisplayed();
        newsPage.clickFirstNewsCard();

        newsPage.checkFirstCardDescriptionTextIsDisplayed();
        newsPage.checkFirstCardDescriptionTextMatch();
    }

    @Test
    public void emptyDescriptionFieldTest() {

        newsPage.checkFirstNewsEditButtonIsDisplayed();
        newsPage.clickFirstNewsEditButton();

        newsPage.checkFirstNewsDescriptionFieldIsDisplayed();
        newsPage.clickFirstNewsDescriptionField();

        newsPage.leaveEmptyDescriptionField();

        newsPage.checkChangeSaveButtonIsDisplayed();
        newsPage.clickChangeSaveButton();

        Espresso.onView(ViewMatchers.withText(R.string.empty_fields)).inRoot(new ToastMatcher()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        newsPage.checkCancelButtonIsDisplayed();
        newsPage.clickCancelButton();

        newsPage.checkCancellationMessageIsDisplayed();

        newsPage.clickOkButton();


    }

    @Test
    public void deleteNewsTest() {

        newsPage.checkFirstNewsEditButtonIsDisplayed();
        newsPage.clickFirstNewsEditButton();

        newsPage.checkFirstNewsDescriptionFieldIsDisplayed();
        newsPage.clickFirstNewsDescriptionField();

        newsPage.enterAnotherDescription();

        newsPage.checkChangeSaveButtonIsDisplayed();
        newsPage.clickChangeSaveButton();

        newsPage.checkFirstNewsCardIsDisplayed();
        newsPage.clickFirstNewsCard();

        newsPage.checkFirstCardAnotherDescriptionTextIsDisplayed();
        newsPage.checkFirstCardAnotherDescriptionMatch();

        newsPage.checkNewsDeleteButtonIsDisplayed();
        newsPage.clickNewsDeleteButton();

        newsPage.checkDeleteWarningIsDisplayed();

        newsPage.checkOkButtonIsDisplayed();
        newsPage.clickOkButton();

        newsPage.checkFirstNewsCardIsDisplayed();
        newsPage.clickFirstNewsCard();

        newsPage.checkFirstCardAnyDescriptionIsDisplayed();

        newsPage.checkFirstCardAnotherDescriptionTextNotMatch();

    }

    @Test
    public void newsNumberInControlPanelTest() {

        int expectedItemCount = 8;

        onView(withId(R.id.news_list_recycler_view)).check(new RecyclerViewItemCountAssertion(expectedItemCount));

    }


}
