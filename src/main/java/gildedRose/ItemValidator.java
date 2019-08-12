package gildedRose;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ItemValidator {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String CONJURED = "Conjured";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static final int MINIMUM_ITEM_QUALITY = 0;
    public static final int MAXIMUM_ITEM_QUALITY = 50;

    private static final  String[] specialItems = {AGED_BRIE, BACKSTAGE_PASSES, SULFURAS, CONJURED };
    private static final Set<String> SPECIAL_ITEMS = new HashSet<>(Arrays.asList(specialItems));

    public ItemValidator() {
    }

    public static boolean itemSellDateHasPassed(Item item) {
        return item.sellIn < 0;
    }

    public static boolean isSpecialItem(String itemName) {
        return SPECIAL_ITEMS.stream()
                .anyMatch(itemName::contains);
    }

    static boolean itemHasNotReachedMaximumQuality(Item item) {
        return item.quality < MAXIMUM_ITEM_QUALITY;
    }

    static boolean itemHasNotReachedMinimumQuality(Item item) {
        return item.quality > MINIMUM_ITEM_QUALITY;
    }

}
