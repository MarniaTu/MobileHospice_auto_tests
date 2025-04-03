package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testdata.TestData;

public class AboutPage {


    public void checkVersionTitleIsDisplayed() {
        onView(withId(R.id.about_version_title_text_view)).check(matches(isDisplayed()));
    }

    public void checkVersionTitleMatch() {
        onView(withId(R.id.about_version_title_text_view)).check(matches(withText("Version:")));
    }


    public void checkBackButtonIsDisplayed() {
        onView(withId(R.id.about_back_image_button)).check(matches(isDisplayed()));
    }

    public void clickBackButton() {
        onView(withId(R.id.about_back_image_button)).perform(click());
    }


    public void checkPrivacyPolicyLabelIsDisplayed() {
        onView(withId(R.id.about_privacy_policy_label_text_view)).check(matches(isDisplayed()));
    }

    public void checkPrivacyPolicyLabelMatch() {
        onView(withId(R.id.about_privacy_policy_label_text_view)).check(matches(withText(TestData.PRIVACY_POLICY_LABEL_TEXT)));
    }

    public void checkPrivacyPolicyLinkTextIsDisplayed() {
        onView(withId(R.id.about_privacy_policy_value_text_view)).check(matches(isDisplayed()));
    }

    public void checkPrivacyPolicyLinkTextMatch() {
        onView(withId(R.id.about_privacy_policy_value_text_view)).check(matches(withText(TestData.PRIVACY_POLICY_LINK_TEXT)));
    }

    public void clickPrivacyPolicyLinkText() {
        onView(withId(R.id.about_privacy_policy_value_text_view)).perform(click());
    }

    public void checkTermsOfUseLabelIsDisplayed() {
        onView(withId(R.id.about_terms_of_use_label_text_view)).check(matches(isDisplayed()));
    }

    public void checkTermsOfUseLabelMatch() {
        onView(withId(R.id.about_terms_of_use_label_text_view)).check(matches(withText(TestData.TERMS_OF_USE_LABEL_TEXT)));
    }


    public void checkTermsOfUseLinkTextIsDisplayed() {
        onView(withId(R.id.about_terms_of_use_value_text_view)).check(matches(isDisplayed()));
    }

    public void checkTermsOfUseLinkTextMatch() {
        onView(withId(R.id.about_terms_of_use_value_text_view)).check(matches(withText(TestData.TERMS_OF_USE_LINK_TEXT)));
    }


    public void clickTermsOfUseLinkText() {
        onView(withId(R.id.about_terms_of_use_value_text_view)).perform(click());
    }


}
