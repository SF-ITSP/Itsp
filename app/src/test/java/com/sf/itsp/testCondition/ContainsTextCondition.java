package com.sf.itsp.testCondition;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.fest.assertions.core.Condition;

import static java.lang.String.format;

public class ContainsTextCondition extends Condition<View> {
    public static final ContainsTextCondition NO_TEXT = new ContainsTextCondition("");
    private final String expectedText;

    public ContainsTextCondition(String expectedText) {
        this.expectedText = expectedText;
    }

    @Override
    public boolean matches(View view) {
        if (view.getVisibility() != View.VISIBLE) {
            describedAs("view not visible");
            return false;
        }

        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childView = viewGroup.getChildAt(i);
                if (matches(childView)) return true;
            }
        }

        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            return containsText(textView) || containsHint(textView);
        }

        return false;
    }

    private boolean containsText(TextView textView) {
        String text = textView.getText().toString();
        System.out.println("\nexpected " + expectedText + "\nactual " + text + "\n");
        return expectedText.equals(text);
    }

    private boolean containsHint(TextView textView) {
        String text = textView.getText().toString();
        CharSequence hintSequence = textView.getHint();
        String hintText = hintSequence == null ? null : hintSequence.toString();

        boolean hintTextIsDisplayed = text.equals("");

        return hintTextIsDisplayed && expectedText.equals(hintText);
    }

    public static ContainsTextCondition text(Object expectedText) {
        return new ContainsTextCondition(expectedText.toString());
    }

    public static ContainsTextCondition text(String expectedText) {
        return new ContainsTextCondition(expectedText);
    }

    public static ContainsTextCondition text(String format, Object... args) {
        return new ContainsTextCondition(format(format, args));
    }

//    public static ContainsTextCondition text(int formatId, Object... args) {
//        return new ContainsTextCondition(format(Robolectric.application.getString(formatId), args));
//    }
}
