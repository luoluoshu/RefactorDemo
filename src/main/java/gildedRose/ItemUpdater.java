package gildedRose;

import static gildedRose.ItemValidator.itemHasNotReachedMaximumQuality;
import static gildedRose.ItemValidator.itemHasNotReachedMinimumQuality;

public class ItemUpdater {
    private ItemUpdater() {
    }

    public static void incrementQualityByOne(Item item) {
        if (itemHasNotReachedMaximumQuality(item)) {
            item.quality++;
        }
    }

    public static void decrementQualityByOne(Item item) {
        if (itemHasNotReachedMinimumQuality(item)) {
            item.quality--;
        }
    }

    public static void setQualityToZero(Item item) {
        item.quality = 0;
    }

    public static void decrementSellInByOne(Item item) {
        item.sellIn--;
    }

}
