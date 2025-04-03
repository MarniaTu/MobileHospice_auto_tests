package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testdata.TestData;
import ru.iteco.fmhandroid.ui.utils.IntViewWaiter;

public class AboutPage {


    public void checkVersionTitleIsDisplayed() {
        Allure.step("Проверка отображения заголовка Version");
        onView(withId(R.id.about_version_title_text_view)).check(matches(isDisplayed()));
    }

    public void checkVersionTitleMatch() {
        Allure.step("Проверка соответствия текста заголовка Version");
        onView(withId(R.id.about_version_title_text_view)).check(matches(withText("Version:")));
    }


    public void checkBackButtonIsDisplayed() {
        Allure.step("Проверка отображения кнопки возврата на предыдущую страницу");
        onView(withId(R.id.about_back_image_button)).check(matches(isDisplayed()));
    }

    public void clickBackButton() {

        Allure.step("Нажатие на кнопку возврата на предыдущую страницу");
        onView(withId(R.id.about_back_image_button)).perform(click());
    }


    public void checkPrivacyPolicyLabelIsDisplayed() {
        Allure.step("Проверка отображения надписи Privacy Policy");
        onView(withId(R.id.about_privacy_policy_label_text_view)).check(matches(isDisplayed()));
    }

    public void checkPrivacyPolicyLabelMatch() {

        Allure.step("Проверка соответствия текста надписи Privacy Policy");
        onView(withId(R.id.about_privacy_policy_label_text_view)).check(matches(withText(TestData.PRIVACY_POLICY_LABEL_TEXT)));
    }

    public void checkPrivacyPolicyLinkTextIsDisplayed() {

        Allure.step("Проверка отображения ссылки на политику конфиденциальности");
        onView(withId(R.id.about_privacy_policy_value_text_view)).check(matches(isDisplayed()));
    }

    public void checkPrivacyPolicyLinkTextMatch() {

        Allure.step("Проверка соответствия текста ссылки на политику конфиденциальности");
        onView(withId(R.id.about_privacy_policy_value_text_view)).check(matches(withText(TestData.PRIVACY_POLICY_LINK_TEXT)));
    }

    public void clickPrivacyPolicyLinkText() {

        Allure.step("Нажатие на ссылку для перехода на политику конфиденциальности");
        onView(withId(R.id.about_privacy_policy_value_text_view)).perform(click());
    }

    public void checkTermsOfUseLabelIsDisplayed() {

        Allure.step("Проверка отображения текста надписи Terms of Use");
        onView(withId(R.id.about_terms_of_use_label_text_view)).check(matches(isDisplayed()));
    }

    public void checkTermsOfUseLabelMatch() {

        Allure.step("Проверка соответствия текста надписи Terms of Use");
        onView(withId(R.id.about_terms_of_use_label_text_view)).check(matches(withText(TestData.TERMS_OF_USE_LABEL_TEXT)));
    }


    public void checkTermsOfUseLinkTextIsDisplayed() {

        Allure.step("Проверка отображения текста ссылки на пользовательское соглашение");
        onView(withId(R.id.about_terms_of_use_value_text_view)).check(matches(isDisplayed()));
    }

    public void checkTermsOfUseLinkTextMatch() {

        Allure.step("Проверка соответствия текста ссылки на пользовательское соглашение");
        onView(withId(R.id.about_terms_of_use_value_text_view)).check(matches(withText(TestData.TERMS_OF_USE_LINK_TEXT)));
    }


    public void clickTermsOfUseLinkText() {

        Allure.step("Нажатие на ссылку для перехода на пользовательское соглашение");
        onView(withId(R.id.about_terms_of_use_value_text_view)).perform(click());
    }


    public void waitVersionTitleIsDisplayed() {

        Allure.step("Ожидание отображения заголовка Version");
        onView(ViewMatchers.isRoot()).perform(IntViewWaiter.waitDisplayed(R.id.about_version_title_text_view, 3000));
    }

}