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
            updateItemSellDate(item);
            updateItemQuality(item);
        }
    }

    private static void updateItemSellDate(Item item) {
        switch (item.name) {
            case ITEM_SULFURAS_HAND_OF_RAGNAROS:
                break;
            default:
                item.sellIn--;
                break;
        }
    }

    private static void updateItemQuality(Item item) {
        switch (item.name) {
            case ITEM_SULFURAS_HAND_OF_RAGNAROS:
                // It is imperative we exit before restricting the quality of regular items
                return;
            case ITEM_AGED_BRIE:
                if (item.sellIn < 0) {
                    item.quality += 2;
                } else {
                    item.quality++;
                }
                break;
            case ITEM_BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                if (item.sellIn < 0) {
                    item.quality = 0;
                } else if (item.sellIn < 6) {
                    item.quality += 3;
                } else if (item.sellIn < 11) {
                    item.quality += 2;
                } else {
                    item.quality++;
                }
                break;
            case ITEM_CONJURED_MANA_CAKE:
                if (item.sellIn < 0) {
                    item.quality -= 4;
                } else {
                    item.quality -= 2;
                }
                break;
            default:
                if (item.sellIn < 0) {
                    item.quality -= 2;
                } else {
                    item.quality--;
                }
                break;
        }

        // Keep quality within bounds
        if (item.quality > MAXIMUM_ITEM_QUALITY) {
            item.quality = MAXIMUM_ITEM_QUALITY;
        }

        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}
