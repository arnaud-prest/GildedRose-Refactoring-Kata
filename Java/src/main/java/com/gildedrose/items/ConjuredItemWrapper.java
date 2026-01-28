package com.gildedrose.items;

import com.gildedrose.Item;

public class ConjuredItemWrapper extends RegularItemWrapper {

    public ConjuredItemWrapper(Item wrappedItem) {
        super(wrappedItem);
    }

    @Override
    protected void updateQuality() {
        if (wrappedItem.sellIn >= 0) {
            wrappedItem.quality -= DEFAULT_DAILY_QUALITY_LOSS * 2;
        } else {
            wrappedItem.quality -= DEFAULT_DAILY_QUALITY_LOSS * 4;
        }
    }
}
