package com.gildedrose;

class GildedRose {
    public static final String ITEM_AGED_BRIE = "Aged Brie";
    public static final String ITEM_BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String ITEM_SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String ITEM_CONJURED_MANA_CAKE = "Conjured Mana Cake";

    public static final int MAXIMUM_ITEM_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private static void updateItemQuality(Item item) {
        if (!item.name.equals(ITEM_AGED_BRIE)
                && !item.name.equals(ITEM_BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            if (item.quality > 0) {
                if (!item.name.equals(ITEM_SULFURAS_HAND_OF_RAGNAROS)) {
                    item.quality = item.quality - 1;
                }
                if (item.name.equals(ITEM_CONJURED_MANA_CAKE)){
                    item.quality--;
                }
            }
        } else {
            if (item.quality < MAXIMUM_ITEM_QUALITY) {
                item.quality = item.quality + 1;

                if (item.name.equals(ITEM_BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                    if (item.sellIn < 11) {
                        if (item.quality < MAXIMUM_ITEM_QUALITY) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < MAXIMUM_ITEM_QUALITY) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!item.name.equals(ITEM_SULFURAS_HAND_OF_RAGNAROS)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals(ITEM_AGED_BRIE)) {
                if (!item.name.equals(ITEM_BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                    if (item.quality > 0) {
                        if (!item.name.equals(ITEM_SULFURAS_HAND_OF_RAGNAROS)) {
                            item.quality = item.quality - 1;
                        }
                        if (item.name.equals(ITEM_CONJURED_MANA_CAKE)){
                            item.quality--;
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < MAXIMUM_ITEM_QUALITY) {
                    item.quality = item.quality + 1;
                }
            }
        }

        // Item quality cannot be negative
        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}
