package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemWrapper;

public class AppreciatingUntilDeadlineItemWrapper extends RegularItemWrapper {

    public AppreciatingUntilDeadlineItemWrapper(Item wrappedItem) {
        super(wrappedItem);
    }

    @Override
    protected void updateQuality() {
        if (wrappedItem.sellIn < 0) {
            wrappedItem.quality = 0;
        } else if (wrappedItem.sellIn < 6) {
            wrappedItem.quality += 3;
        } else if (wrappedItem.sellIn < 11) {
            wrappedItem.quality += 2;
        } else {
            wrappedItem.quality++;
        }
    }
}
