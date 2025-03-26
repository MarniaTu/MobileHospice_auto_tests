package ru.iteco.fmhandroid.ui.utils;

import android.view.View;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class ByIndexMatcher {

    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new BaseMatcher<View>() {
            int currentIndex = 0;

            @Override
            public boolean matches(Object item) {
                if (matcher.matches(item)) {
                    if (currentIndex == index) {
                        currentIndex++;
                        return true;
                    }
                    currentIndex++;
                }
                return false;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: " + index);
                matcher.describeTo(description);
            }
        };
    }
}
