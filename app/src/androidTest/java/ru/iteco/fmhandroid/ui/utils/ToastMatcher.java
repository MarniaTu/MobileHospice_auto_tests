package ru.iteco.fmhandroid.ui.utils;

import androidx.test.espresso.Root;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ToastMatcher extends TypeSafeMatcher<Root> {

    @Override
    public void describeTo(Description description) {
        description.appendText("is toast");
    }

    @Override
    protected boolean matchesSafely(Root root) {
        // Проверяем, что Root является Toast
        return root.getWindowLayoutParams().get().type == android.view.WindowManager.LayoutParams.TYPE_TOAST;
    }

    public static Matcher<Root> isToast() {
        return new ToastMatcher();
    }
}
