package com.gildedrose;

public abstract class ItemWrapper {
    protected static final int DEFAULT_DAILY_QUALITY_LOSS = 1;

    protected final Item wrappedItem;

    public ItemWrapper(Item wrappedItem) {
        this.wrappedItem = wrappedItem;
    }

    public abstract void updadeItemAtTheEndOfTheDay();
}
