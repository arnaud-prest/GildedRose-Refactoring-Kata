package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemWrapper;

public class RegularItemWrapper extends ItemWrapper {
    protected static final int MAXIMUM_ITEM_QUALITY = 50;

    public RegularItemWrapper(Item wrappedItem) {
        super(wrappedItem);
    }

    @Override
    public final void updadeItemAtTheEndOfTheDay() {
        wrappedItem.sellIn--;

        updateQuality();

        if (wrappedItem.quality > MAXIMUM_ITEM_QUALITY) {
            wrappedItem.quality = MAXIMUM_ITEM_QUALITY;
        } else if (wrappedItem.quality < 0) {
            wrappedItem.quality = 0;
        }
    }

    protected void updateQuality() {
        if (wrappedItem.sellIn >= 0) {
            wrappedItem.quality -= DEFAULT_DAILY_QUALITY_LOSS;
        } else {
            wrappedItem.quality -= DEFAULT_DAILY_QUALITY_LOSS * 2;
        }
    }
}
