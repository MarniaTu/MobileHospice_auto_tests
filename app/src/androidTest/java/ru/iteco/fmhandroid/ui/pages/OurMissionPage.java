package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.ByIndexMatcher.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testdata.TestData;
import ru.iteco.fmhandroid.ui.utils.RecyclerViewUtils;

public class OurMissionPage {

    private String expectedText;

    private ViewInteraction getOurMissionTitle() {
        return onView(withId(R.id.our_mission_title_text_view));
    }

    public void checkOurMissionTitleIsDisplayed() {
        getOurMissionTitle().check(matches(isDisplayed()));
    }

    public void checkOurMissionTitleMatch() {
        getOurMissionTitle().check(matches(withText(TestData.OUR_MISSION_TITLE)));
    }

    private ViewInteraction getFirstOurMissionCardText() {
        return onView(withIndex(allOf(withId(R.id.our_mission_item_description_text_view), isDisplayed()), 0));
    }

    public void checkFirstOurMissionCardTextIsDisplayed() {
        getFirstOurMissionCardText().check(matches(isDisplayed()));


//    String expectedText = RecyclerViewUtils.getTextFromRecyclerViewItem(R.id.our_mission_item_list_recycler_view,
//            0, R.id.our_mission_item_material_card_view, R.id.our_mission_item_description_text_view);

        this.expectedText = RecyclerViewUtils.getTextFromRecyclerViewItem(
                R.id.our_mission_item_list_recycler_view,
                0,
                R.id.our_mission_item_material_card_view,
                R.id.our_mission_item_description_text_view
        );

    }

    public void checkFirstOurMissionCardTextExpectedMatch() {
        getFirstOurMissionCardText().check(matches(withText(expectedText)));
    }

}
