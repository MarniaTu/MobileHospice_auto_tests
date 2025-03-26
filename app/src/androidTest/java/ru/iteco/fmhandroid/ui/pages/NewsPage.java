package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.utils.ByIndexMatcher.withIndex;
import static ru.iteco.fmhandroid.ui.utils.CustomViewActions.waitForDisplayed;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testdata.TestData;

public class NewsPage {

    private ViewInteraction getEditNewsButton() {
        return onView(withId(R.id.edit_news_material_button));
    }

    public void checkEditNewsButtonIsDisplayed() {
        getEditNewsButton().check(matches(isDisplayed()));
    }

    public void clickEditNewsButton() {
        getEditNewsButton().perform(click());
    }

    private ViewInteraction getFilterButton() {
        return onView((withId(R.id.filter_news_material_button)));
    }

    public void checkFilterButtonIsDisplayed() {
        getFilterButton().check(matches(isDisplayed()));
    }

    private ViewInteraction getControlPanelText() {

        return onView(
                allOf(withText("Control panel"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))), isDisplayed()));
    }

    public void checkControlPanelTextIsDisplayed() {
        getControlPanelText().check(matches(isDisplayed()));
    }

    public void checkControlPanelTextMatch() {
        getControlPanelText().check(matches(withText("Control panel")));
    }

    public void checkFirstNewsEditButtonIsDisplayed() {
        onView(withIndex(allOf(
                withId(R.id.edit_news_item_image_view),
                withContentDescription("News editing button"),
                isDisplayed()
        ), 0)).check(matches(isDisplayed()));
    }

    public void clickFirstNewsEditButton() {
        onView(withIndex(allOf(
                withId(R.id.edit_news_item_image_view),
                withContentDescription("News editing button"),
                isDisplayed()
        ), 0)).perform(click());
    }

    private ViewInteraction getFirstNewsDescriptionField() {
        return onView(withId(R.id.news_item_description_text_input_edit_text));
    }

    public void checkFirstNewsDescriptionFieldIsDisplayed() {
        getFirstNewsDescriptionField().check(matches(isDisplayed()));
    }

    public void clickFirstNewsDescriptionField() {
        getFirstNewsDescriptionField().perform(click());
    }

    public void enterNewDescription() {
        getFirstNewsDescriptionField().perform(replaceText(TestData.NEW_NEWS_DESCRIPTION), closeSoftKeyboard());
    }

    public void enterAnotherDescription() {
        getFirstNewsDescriptionField().perform(replaceText(TestData.ANOTHER_NEWS_DESCRIPTION), closeSoftKeyboard());
    }

    public void checkNewNewsDescriptionFieldIsDisplayed() {
        onView(withId(R.id.news_item_description_text_input_edit_text)).check(matches(isDisplayed()));
    }

    public void enterNewNewsDescription() {
        onView(withId(R.id.news_item_description_text_input_edit_text)).perform(replaceText(TestData.NEW_NEWS_CREATING_DESCRIPTION), closeSoftKeyboard());
    }

    public void leaveEmptyDescriptionField() {
        getFirstNewsDescriptionField().perform(replaceText(TestData.EMPTY_NEWS_DESCRIPTION), closeSoftKeyboard());
    }


    private ViewInteraction getChangeSaveButton() {
        return onView(withId(R.id.save_button));
    }

    public void checkChangeSaveButtonIsDisplayed() {
        getChangeSaveButton().check(matches(isDisplayed()));
    }

    public void clickChangeSaveButton() {
        getChangeSaveButton().perform(scrollTo(), click());
    }


    private ViewInteraction getFirstNewsCard() {
        return onView(allOf(withId(R.id.news_list_recycler_view), childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0)));
    }

    public void checkFirstNewsCardIsDisplayed() {
        getFirstNewsCard().check(matches(isDisplayed()));
    }

    public void clickFirstNewsCard() {
        getFirstNewsCard().perform(actionOnItemAtPosition(0, click()));
    }


    public void checkFirstCardDescriptionTextIsDisplayed() {
        onView(withIndex(allOf(withId(R.id.news_item_description_text_view), withText(TestData.NEW_NEWS_DESCRIPTION), isDisplayed()), 0)).check(matches(isDisplayed()));
    }


    public void checkFirstCardDescriptionTextMatch() {
        onView(withIndex(allOf(withId(R.id.news_item_description_text_view), withText(TestData.NEW_NEWS_DESCRIPTION), isDisplayed()), 0)).check(matches(withText(TestData.NEW_NEWS_DESCRIPTION)));

    }

    public void checkFirstCardAnotherDescriptionTextIsDisplayed() {
        onView(withIndex(allOf(withId(R.id.news_item_description_text_view), withText(TestData.ANOTHER_NEWS_DESCRIPTION), isDisplayed()), 0)).check(matches(isDisplayed()));
    }

    public void checkFirstCardAnotherDescriptionMatch() {
        onView(withIndex(allOf(withId(R.id.news_item_description_text_view), withText(TestData.ANOTHER_NEWS_DESCRIPTION), isDisplayed()), 0)).check(matches(withText(TestData.ANOTHER_NEWS_DESCRIPTION)));
    }

    public void checkFirstCardAnotherDescriptionTextNotMatch() {
        onView(withIndex(allOf(withId(R.id.news_item_description_text_view), isDisplayed()), 0)).check(matches(not(withText(TestData.ANOTHER_NEWS_DESCRIPTION))));
    }

    public void checkFirstCardAnyDescriptionIsDisplayed() {
        onView(withIndex(allOf(withId(R.id.news_item_description_text_view), isDisplayed()), 0)).check(matches(isDisplayed()));
    }

    public void checkNewCardDescriptionIsDisplayed() {
        onView(withIndex(allOf(withId(R.id.news_item_description_text_view), withText(TestData.NEW_NEWS_CREATING_DESCRIPTION), isDisplayed()), 0)).check(matches(isDisplayed()));
    }

    public void checkNewCardDescriptionMatch() {
        onView(withIndex(allOf(withId(R.id.news_item_description_text_view), withText(TestData.NEW_NEWS_CREATING_DESCRIPTION), isDisplayed()), 0)).check(matches(withText(TestData.NEW_NEWS_CREATING_DESCRIPTION)));
    }


    private ViewInteraction getCancelButton() {
        return onView(withId(R.id.cancel_button));
    }

    public void checkCancelButtonIsDisplayed() {
        getCancelButton().check(matches(isDisplayed()));
    }

    public void clickCancelButton() {
        getCancelButton().perform(scrollTo(), click());
    }

    private ViewInteraction getCancellationMessage() {
        return onView(withText(R.string.cancellation)).perform(waitForDisplayed(5000));
    }

    public void checkCancellationMessageIsDisplayed() {
        getCancellationMessage().check(matches(isDisplayed()));
    }

    private ViewInteraction getOkButton() {
        return onView(withText(R.string.fragment_positive_button));
    }

    public void checkOkButtonIsDisplayed() {
        getOkButton().check(matches(isDisplayed()));
    }

    public void clickOkButton() {
        getOkButton().perform(click());
    }

    private ViewInteraction getNewsDeleteButton() {
        return onView(withIndex(allOf(withId(R.id.delete_news_item_image_view), withContentDescription("News delete button"), isDisplayed()), 0));
    }

    public void checkNewsDeleteButtonIsDisplayed() {
        getNewsDeleteButton().check(matches(isDisplayed()));
    }

    public void clickNewsDeleteButton() {
        getNewsDeleteButton().perform(click());
    }

    private ViewInteraction getDeletionWarning() {
        return onView(withText(R.string.irrevocable_deletion)).perform(waitForDisplayed(10000));
    }

    public void checkDeleteWarningIsDisplayed() {
        getDeletionWarning().check(matches(isDisplayed()));
    }

    private ViewInteraction getAddNewsButton() {
        return onView(withId(R.id.add_news_image_view));
    }

    public void checkAddNewsButtonIsDisplayed() {
        getAddNewsButton().check(matches(isDisplayed()));
    }

    public void clickAddNewsButton() {
        getAddNewsButton().perform(click());
    }

    private ViewInteraction getDropdownButton() {
        return onView(withIndex(allOf(withId(R.id.text_input_end_icon), withContentDescription("Show dropdown menu"), isDisplayed()), 0));
    }

    public void checkDropDownButtonIsDisplayed() {
        getDropdownButton().check(matches(isDisplayed()));
    }

    public void clickDropDownButton() {
        getDropdownButton().perform(click());
    }

    private ViewInteraction getDateField() {
        return onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    }

    public void checkDateFieldIsDisplayed() {
        getDateField().check(matches(isDisplayed()));
    }

    public void enterNewDate() {
        getDateField().perform(replaceText(TestData.NEW_DATE), closeSoftKeyboard());
    }

    private ViewInteraction getTimeField() {
        return onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    }

    public void checkTimeFieldIsDisplayed() {
        getTimeField().check(matches(isDisplayed()));
    }

    public void enterNewTime() {
        getTimeField().perform(replaceText(TestData.NEW_TIME), closeSoftKeyboard());
    }


    private static Matcher<View> childAtPosition(final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent) && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
