package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.ByIndexMatcher.withIndex;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testdata.TestData;
import ru.iteco.fmhandroid.ui.utils.RecyclerViewUtils;

public class OurMissionPage {

    private String expectedText;

    public void checkOurMissionTitleIsDisplayed() {
        onView(withId(R.id.our_mission_title_text_view)).check(matches(isDisplayed()));
    }

    public void checkOurMissionTitleMatch() {
        onView(withId(R.id.our_mission_title_text_view)).check(matches(withText(TestData.OUR_MISSION_TITLE)));
    }

    public void checkFirstOurMissionCardTextIsDisplayed() {
        onView(withIndex(allOf(withId(R.id.our_mission_item_description_text_view), isDisplayed()), 0)).check(matches(isDisplayed()));


        this.expectedText = RecyclerViewUtils.getTextFromRecyclerViewItem(
                R.id.our_mission_item_list_recycler_view,
                0,
                R.id.our_mission_item_material_card_view,
                R.id.our_mission_item_description_text_view
        );

    }

    public void checkFirstOurMissionCardTextExpectedMatch() {
        onView(withIndex(allOf(withId(R.id.our_mission_item_description_text_view), isDisplayed()), 0)).check(matches(withText(expectedText)));
    }

}
