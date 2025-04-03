package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
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
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.utils.AllureScreenshotWatcher;
import ru.iteco.fmhandroid.ui.utils.RecyclerViewItemCountAssertion;
import ru.iteco.fmhandroid.ui.utils.ToastMatcher;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Feature("Редактирование новостей")
public class EditNewsTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public AllureScreenshotWatcher screenshotWatcher = new AllureScreenshotWatcher();

    private LoginPage loginPage;
    private MainPage mainPage;
    private NewsPage newsPage;


    @Before

    public void setUp() {

        loginPage = new LoginPage();
        loginPage.waitUntilLoginScreenLoaded();
        mainPage = loginPage.performSuccessLogin();

        mainPage.checkAllNewsTextIsDisplayed();
        mainPage.checkAllNewsTextMatch();

        mainPage.checkMainMenuButtonIsDisplayed();
        mainPage.clickMainMenuButton();

        mainPage.checkNewsMenuItemIsDisplayed();
        mainPage.clickNewsMenuItem();

        newsPage = new NewsPage();
        newsPage.waitEditNewsButtonIsDisplayed();
        newsPage.checkEditNewsButtonIsDisplayed();
        newsPage.clickEditNewsButton();

    }

    @After
    public void tearDown() {

        mainPage.performLogOut();

        loginPage.checkAuthTextIsDisplayed();
        loginPage.checkAuthTextMatch();

    }

    @Test
    @Story("Изменение описания первой новости")
    @Description("Пользователь может внести изменение в текст описания опубликованной новости")
    public void changeDescriptionTest() {

        newsPage.checkFirstNewsEditButtonIsDisplayed();
        newsPage.clickFirstNewsEditButton();

        newsPage.checkNewsDescriptionFieldIsDisplayed();
        newsPage.clickNewsDescriptionField();
        newsPage.enterNewDescription();

        newsPage.checkChangeSaveButtonIsDisplayed();
        newsPage.clickChangeSaveButton();

        newsPage.checkFirstNewsCardIsDisplayed();
        newsPage.clickFirstNewsCard();

        newsPage.checkFirstCardDescriptionTextIsDisplayed();
        newsPage.checkFirstCardDescriptionTextMatch();
    }

    @Test
    @Story("Попытка оставить пустым поле описания первой новости")
    @Description("При попытке оставить пустым поле описания новости пользователь не может сохранить изменения")
    public void emptyDescriptionFieldTest() {

        newsPage.checkFirstNewsEditButtonIsDisplayed();
        newsPage.clickFirstNewsEditButton();

        newsPage.checkNewsDescriptionFieldIsDisplayed();
        newsPage.clickNewsDescriptionField();

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
    @Story("Удаление первой новости")
    @Description("Пользователь может удалить опубликованную новость")
    public void deleteNewsTest() {

        newsPage.checkFirstNewsEditButtonIsDisplayed();
        newsPage.clickFirstNewsEditButton();

        newsPage.checkNewsDescriptionFieldIsDisplayed();
        newsPage.clickNewsDescriptionField();

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
    @Story("Подсчет количества новостей на экране контрольной панели")
    @Description("На экране контрольной панели отображаются 8 карточек с новостями")
    public void newsNumberInControlPanelTest() {

        int expectedItemCount = 8;

        onView(withId(R.id.news_list_recycler_view)).check(new RecyclerViewItemCountAssertion(expectedItemCount));

    }


}
