package com.gildedrose;

import java.util.Arrays;

public enum ItemReference {
    DEFAULT_ITEM(""),
    SULFURAS_HAND_OF_RAGNAROS("Sulfuras, Hand of Ragnaros"),
    AGED_BRIE ("Aged Brie"),
    BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED_MANA_CAKE("Conjured Mana Cake");

    private final String name;

    ItemReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ItemReference fromItemName(String itemName) {
       return Arrays.stream(ItemReference.values())
            .filter((reference) -> reference.name.equals(itemName))
            .findFirst().orElse(DEFAULT_ITEM);
    }
}
