package com.gildedrose;

import com.gildedrose.items.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ItemWrapperFactory {

    private static final Map<ItemReference, Function<Item, ItemWrapper>> MAPPERS = new HashMap<>();

    static {
        MAPPERS.put(ItemReference.DEFAULT_ITEM, RegularItemWrapper::new);
        MAPPERS.put(ItemReference.SULFURAS_HAND_OF_RAGNAROS, LegendaryItemWrapper::new);
        MAPPERS.put(ItemReference.AGED_BRIE, AppreciatingItemWrapper::new);
        MAPPERS.put(ItemReference.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, AppreciatingUntilDeadlineItemWrapper::new);
        MAPPERS.put(ItemReference.CONJURED_MANA_CAKE, ConjuredItemWrapper::new);
    }

    public static ItemWrapper of(Item item) {
        return MAPPERS.get(ItemReference.fromItemName(item.name)).apply(item);
    }

}
