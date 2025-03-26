package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testdata.TestData;

public class AboutPage {

    private ViewInteraction getVersionTitle() {
        return onView(withId(R.id.about_version_title_text_view));
    }

    public void checkVersionTitleIsDisplayed() {
        getVersionTitle().check(matches(isDisplayed()));
    }

    public void checkVersionTitleMatch() {
        getVersionTitle().check(matches(withText("Version:")));
    }


    private ViewInteraction getBackButton() {
        return onView(withId(R.id.about_back_image_button));
    }

    public void checkBackButtonIsDisplayed() {
        getBackButton().check(matches(isDisplayed()));
    }

    public void clickBackButton() {
        getBackButton().perform(click());
    }

    private ViewInteraction getPrivacyPolicyLabel() {
        return onView(withId(R.id.about_privacy_policy_label_text_view));
    }

    public void checkPrivacyPolicyLabelIsDisplayed() {
        getPrivacyPolicyLabel().check(matches(isDisplayed()));
    }

    public void checkPrivacyPolicyLabelMatch() {
        getPrivacyPolicyLabel().check(matches(withText(TestData.PRIVACY_POLICY_LABEL_TEXT)));
    }

    private ViewInteraction getPrivacyPolicyLinkText() {
        return onView(withId(R.id.about_privacy_policy_value_text_view));
    }

    public void checkPrivacyPolicyLinkTextIsDisplayed() {
        getPrivacyPolicyLinkText().check(matches(isDisplayed()));
    }

    public void checkPrivacyPolicyLinkTextMatch() {
        getPrivacyPolicyLinkText().check(matches(withText(TestData.PRIVACY_POLICY_LINK_TEXT)));
    }


    public void clickPrivacyPolicyLinkText() {
        getPrivacyPolicyLinkText().perform(click());
    }

    private ViewInteraction getTermsOfUseLabel() {
        return onView(withId(R.id.about_terms_of_use_label_text_view));
    }

    public void checkTermsOfUseLabelIsDisplayed() {
        getTermsOfUseLabel().check(matches(isDisplayed()));
    }

    public void checkTermsOfUseLabelMatch() {
        getTermsOfUseLabel().check(matches(withText(TestData.TERMS_OF_USE_LABEL_TEXT)));
    }

    private ViewInteraction getTermsOfUseLinkText() {
        return onView(withId(R.id.about_terms_of_use_value_text_view));
    }

    public void checkTermsOfUseLinkTextIsDisplayed() {
        getTermsOfUseLinkText().check(matches(isDisplayed()));
    }

    public void checkTermsOfUseLinkTextMatch() {
        getTermsOfUseLinkText().check(matches(withText(TestData.TERMS_OF_USE_LINK_TEXT)));
    }


    public void clickTermsOfUseLinkText() {
        getTermsOfUseLinkText().perform(click());
    }


}
