package ru.iteco.fmhandroid.ui.utils;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import com.google.android.material.card.MaterialCardView;

import org.hamcrest.Matcher;

public class RecyclerViewUtils {

    public static String getTextFromRecyclerViewItem(int recyclerViewId, int position, int cardViewId, int textViewId) {
        final String[] text = new String[1];
        onView(withId(recyclerViewId)).perform(
                RecyclerViewActions.actionOnItemAtPosition(position, new ViewAction() {
                    @Override
                    public Matcher<View> getConstraints() {
                        return isAssignableFrom(RecyclerView.class);
                    }

                    @Override
                    public String getDescription() {
                        return "Getting text from RecyclerView item at position " + position;
                    }

                    @Override
                    public void perform(UiController uiController, View view) {
                        // Находим MaterialCardView внутри элемента RecyclerView
                        MaterialCardView cardView = view.findViewById(cardViewId);
                        if (cardView != null) {
                            // Находим TextView внутри MaterialCardView
                            TextView textView = cardView.findViewById(textViewId);
                            if (textView != null) {
                                text[0] = textView.getText().toString();
                            }
                        }
                    }
                })
        );
        return text[0];
    }
}
