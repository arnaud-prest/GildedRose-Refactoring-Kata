package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemWrapper;

public class AppreciatingItemWrapper extends RegularItemWrapper {

    public AppreciatingItemWrapper(Item wrappedItem) {
        super(wrappedItem);
    }

    @Override
    protected void updateQuality() {
        if (wrappedItem.sellIn >= 0) {
            wrappedItem.quality += DEFAULT_DAILY_QUALITY_LOSS;
        } else {
            wrappedItem.quality += DEFAULT_DAILY_QUALITY_LOSS * 2;
        }
    }
}
