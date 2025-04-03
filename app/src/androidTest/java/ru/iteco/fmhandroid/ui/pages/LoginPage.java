package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testdata.TestData;
import ru.iteco.fmhandroid.ui.utils.IntViewWaiter;
import ru.iteco.fmhandroid.ui.utils.ToastMatcher;

public class LoginPage {


    public void checkLoginFieldIsDisplayed() {
        Allure.step("Проверка отображения поля логина");
        onView(allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout))))).check(matches(isDisplayed()));
    }


    public void enterCorrectLogin() {
        Allure.step("Ввод валидного логина");
        onView(allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout))))).perform(replaceText(TestData.LOGIN_CORRECT), closeSoftKeyboard());
    }

    public void enterWrongLogin() {
        Allure.step("Ввод невалидного логина");
        onView(allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout))))).perform(replaceText(TestData.LOGIN_WRONG));
    }


    public void checkPasswordFieldIsDisplayed() {

        Allure.step("Проверка отображения поля пароля");
        onView(allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout))))).check(matches(isDisplayed()));
    }


    public void enterCorrectPassword() {

        Allure.step("Ввод валидного пароля");
        onView(allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout))))).perform(replaceText(TestData.PASS_CORRECT), closeSoftKeyboard());
    }


    public void checkSignInButtonIsDisplayed() {

        Allure.step("Проверка отображения кнопки входа в личный кабинет");
        onView(withId(R.id.enter_button)).check(matches(isDisplayed()));
    }


    public void clickSignInButton() {

        Allure.step("Нажатие на кнопку входа в личный кабинет");
        onView(withId(R.id.enter_button)).perform(click());
    }


    public void checkAuthTextIsDisplayed() {

        Allure.step("Проверка отображения текста Authorization");
        onView(allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment))))).check(matches(isDisplayed()));
    }

    public void checkAuthTextMatch() {

        Allure.step("Проверка соответствия отображенного текста Authorization");
        onView(allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment))))).check(matches(withText("Authorization")));
    }


    public void waitUntilLoginScreenLoaded() {

        Allure.step("Ожидание загрузки страницы авторизации");
        Espresso.onView(ViewMatchers.isRoot())
                .perform(IntViewWaiter.waitDisplayed(R.id.enter_button, 10000));
        checkAuthTextIsDisplayed();
        checkAuthTextMatch();
    }


    public MainPage performSuccessLogin() {


        checkLoginFieldIsDisplayed();


        enterCorrectLogin();


        checkPasswordFieldIsDisplayed();

        enterCorrectPassword();


        checkSignInButtonIsDisplayed();

        clickSignInButton();

        Espresso.onView(isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.all_news_text_view, 5000));


        return new MainPage();

    }

    public void emptyFieldWarning() {

        Allure.step("Системное сообщение о необходимости заполнить поле");
        Espresso.onView(ViewMatchers.withText(R.string.empty_login_or_password)).inRoot(new ToastMatcher()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    public void wrongLoginOrPasswordWarning() {
        Allure.step("Системное сообщение об ошибке в логине или пароле");
        Espresso.onView(ViewMatchers.withText(R.string.wrong_login_or_password)).inRoot(new ToastMatcher()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }


}
