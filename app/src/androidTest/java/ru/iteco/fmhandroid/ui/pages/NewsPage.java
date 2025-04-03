package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.utils.ByIndexMatcher.withIndex;
import static ru.iteco.fmhandroid.ui.utils.CustomViewActions.waitForDisplayed;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testdata.TestData;

public class NewsPage {

    public void checkEditNewsButtonIsDisplayed() {
        onView(withId(R.id.edit_news_material_button)).check(matches(isDisplayed()));
    }

    public void clickEditNewsButton() {
        onView(withId(R.id.edit_news_material_button)).perform(click());
    }

    public void checkFilterButtonIsDisplayed() {
        onView((withId(R.id.filter_news_material_button))).check(matches(isDisplayed()));
    }

    public void checkControlPanelTextIsDisplayed() {
        onView(
                allOf(withText("Control panel"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))), isDisplayed())).check(matches(isDisplayed()));
    }

    public void checkControlPanelTextMatch() {
        onView(
                allOf(withText("Control panel"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))), isDisplayed())).check(matches(withText("Control panel")));
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

    public void checkNewsDescriptionFieldIsDisplayed() {
        onView(withId(R.id.news_item_description_text_input_edit_text)).check(matches(isDisplayed()));
    }

    public void clickNewsDescriptionField() {
        onView(withId(R.id.news_item_description_text_input_edit_text)).perform(click());
    }

    public void enterNewDescription() {
        onView(withId(R.id.news_item_description_text_input_edit_text)).perform(replaceText(TestData.NEW_NEWS_DESCRIPTION), closeSoftKeyboard());
    }

    public void enterAnotherDescription() {
        onView(withId(R.id.news_item_description_text_input_edit_text)).perform(replaceText(TestData.ANOTHER_NEWS_DESCRIPTION), closeSoftKeyboard());
    }

    public void enterNewNewsDescription() {
        onView(withId(R.id.news_item_description_text_input_edit_text)).perform(replaceText(TestData.NEW_NEWS_CREATING_DESCRIPTION), closeSoftKeyboard());
    }

    public void leaveEmptyDescriptionField() {
        onView(withId(R.id.news_item_description_text_input_edit_text)).perform(replaceText(TestData.EMPTY_NEWS_DESCRIPTION), closeSoftKeyboard());
    }

    public void checkChangeSaveButtonIsDisplayed() {
        onView(withId(R.id.save_button)).check(matches(isDisplayed()));
    }

    public void clickChangeSaveButton() {
        onView(withId(R.id.save_button)).perform(scrollTo(), click());
    }

    public void checkFirstNewsCardIsDisplayed() {
        onView(allOf(withId(R.id.news_list_recycler_view), childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0))).check(matches(isDisplayed()));
    }

    public void clickFirstNewsCard() {
        onView(allOf(withId(R.id.news_list_recycler_view), childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0))).perform(actionOnItemAtPosition(0, click()));
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

    public void checkCancelButtonIsDisplayed() {
        onView(withId(R.id.cancel_button)).check(matches(isDisplayed()));
    }

    public void clickCancelButton() {
        onView(withId(R.id.cancel_button)).perform(scrollTo(), click());
    }

    public void checkCancellationMessageIsDisplayed() {
        onView(withText(R.string.cancellation)).perform(waitForDisplayed(5000)).check(matches(isDisplayed()));
    }

    public void checkOkButtonIsDisplayed() {
        onView(withText(R.string.fragment_positive_button)).check(matches(isDisplayed()));
    }

    public void clickOkButton() {
        onView(withText(R.string.fragment_positive_button)).perform(click());
    }

    public void checkNewsDeleteButtonIsDisplayed() {
        onView(withIndex(allOf(withId(R.id.delete_news_item_image_view), withContentDescription("News delete button"), isDisplayed()), 0)).check(matches(isDisplayed()));
    }

    public void clickNewsDeleteButton() {
        onView(withIndex(allOf(withId(R.id.delete_news_item_image_view), withContentDescription("News delete button"), isDisplayed()), 0)).perform(click());
    }

    public void checkDeleteWarningIsDisplayed() {
        onView(withText(R.string.irrevocable_deletion)).perform(waitForDisplayed(10000)).check(matches(isDisplayed()));
    }

    public void checkAddNewsButtonIsDisplayed() {
        onView(withId(R.id.add_news_image_view)).check(matches(isDisplayed()));
    }

    public void clickAddNewsButton() {
        onView(withId(R.id.add_news_image_view)).perform(click());
    }

    public void checkDropDownButtonIsDisplayed() {
        onView(withIndex(allOf(withId(R.id.text_input_end_icon), withContentDescription("Show dropdown menu"), isDisplayed()), 0)).check(matches(isDisplayed()));
    }

    public void clickDropDownButton() {
        onView(withIndex(allOf(withId(R.id.text_input_end_icon), withContentDescription("Show dropdown menu"), isDisplayed()), 0)).perform(click());
    }


    public void checkNewsTitleIsDisplayed() {

        onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_title_text_input_layout),
                                        0),
                                1))).check(matches(isDisplayed()));
    }


    public void enterNewsTitle() {

        onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_title_text_input_layout),
                                        0),
                                1))).perform(replaceText(TestData.NEWS_TITLE_TEXT));

    }

    public void checkDateFieldIsDisplayed() {
        onView(withId(R.id.news_item_publish_date_text_input_edit_text)).check(matches(isDisplayed()));
    }

    public void enterNewDate() {
        onView(withId(R.id.news_item_publish_date_text_input_edit_text)).perform(replaceText(TestData.NEW_DATE), closeSoftKeyboard());
    }


    public void checkTimeFieldIsDisplayed() {
        onView(withId(R.id.news_item_publish_time_text_input_edit_text)).check(matches(isDisplayed()));
    }

    public void enterNewTime() {
        onView(withId(R.id.news_item_publish_time_text_input_edit_text)).perform(replaceText(TestData.NEW_TIME), closeSoftKeyboard());
    }

    public void scrollDownNewsList() {
        Allure.step("Прокрутить до опубликованной новости");
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()))
                .perform(RecyclerViewActions.scrollTo(hasDescendant(withText(TestData.NEWS_TITLE_TEXT))));
    }

    public void checkAddedNewsTitleIsDisplayed() {
        Allure.step("Проверить заголовок новой новости на видимость");
        onView(allOf(withText(TestData.NEWS_TITLE_TEXT), withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))).check(matches(isDisplayed()));
        onView(allOf(withText(TestData.NEWS_TITLE_TEXT), withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))).check(matches(withText(endsWith(TestData.NEWS_TITLE_TEXT))));
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
