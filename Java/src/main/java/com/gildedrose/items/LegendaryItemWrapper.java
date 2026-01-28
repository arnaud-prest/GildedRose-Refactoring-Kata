package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemWrapper;

public class LegendaryItemWrapper extends ItemWrapper {

    public LegendaryItemWrapper(Item wrappedItem) {
        super(wrappedItem);
    }

    @Override
    public void updadeItemAtTheEndOfTheDay() {
        // No-op, as this does not change, ever
    }
}
