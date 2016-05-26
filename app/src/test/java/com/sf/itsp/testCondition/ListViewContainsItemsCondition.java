package com.sf.itsp.testCondition;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.fest.assertions.core.Condition;

public class ListViewContainsItemsCondition extends Condition<View> {
    private final int numberOfItems;

    public ListViewContainsItemsCondition(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @Override
    public boolean matches(View view) {
        ListView listView = (ListView) view;
        int count = getCount(listView);
        describedAs("\nexpected has " + numberOfItems + " items but was " + count + "\n");
        return count == numberOfItems;
    }

    private int getCount(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        return adapter == null ? 0 : adapter.getCount();
    }

    public static ListViewContainsItemsCondition numberOfItems(int numberOfItems) {
        return new ListViewContainsItemsCondition(numberOfItems);
    }
}