package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testdata.TestData;

public class LoginPage {

    private ViewInteraction getLoginField() {
        return onView(allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout)))));
    }

    public void checkLoginFieldIsDisplayed() {
        getLoginField().check(matches(isDisplayed()));
    }

    public void enterCorrectLogin() {
        getLoginField().perform(replaceText(TestData.LOGIN_CORRECT), closeSoftKeyboard());
    }

    public void enterWrongLogin() {
        getLoginField().perform(replaceText(TestData.LOGIN_WRONG));
    }

    private ViewInteraction getPasswordField() {
        return onView(allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout)))));
    }

    public void checkPasswordFieldIsDisplayed() {

        getPasswordField().check(matches(isDisplayed()));
    }

    public void enterCorrectPassword() {

        getPasswordField().perform(replaceText(TestData.PASS_CORRECT), closeSoftKeyboard());
    }


    private ViewInteraction getSignInButton() {
        return onView(withId(R.id.enter_button));
    }

    public void checkSignInButtonIsDisplayed() {
        getSignInButton().check(matches(isDisplayed()));
    }

    public void clickSignInButton() {
        getSignInButton().perform(click());
    }


    private ViewInteraction getAuthText() {
        return onView(allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment)))));
    }

    public void checkAuthTextIsDisplayed() {
        getAuthText().check(matches(isDisplayed()));
    }

    public void checkAuthTextMatch() {
        getAuthText().check(matches(withText("Authorization")));
    }


}
