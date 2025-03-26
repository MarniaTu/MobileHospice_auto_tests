package ru.iteco.fmhandroid.ui.utils;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.TreeIterables;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class IntViewWaiter {


    public static ViewAction waitDisplayed(int viewId, long timeout) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isRoot();
            }

            @Override
            public String getDescription() {
                return "Ждать, пока элемент с ID " + viewId + " не станет видимым в течение " + timeout + " мс";
            }

            @Override
            public void perform(UiController uiController, View view) {
                long endTime = System.currentTimeMillis() + timeout;
                Matcher<View> viewMatcher = Matchers.allOf(ViewMatchers.withId(viewId), ViewMatchers.isDisplayed());

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        if (viewMatcher.matches(child)) {
                            return;
                        }
                    }
                    uiController.loopMainThreadForAtLeast(50); // Ждем 50 мс перед следующей проверкой
                } while (System.currentTimeMillis() < endTime);


                throw new RuntimeException("Элемент с ID " + viewId + " не стал видимым за " + timeout + " мс");
            }
        };
    }
}