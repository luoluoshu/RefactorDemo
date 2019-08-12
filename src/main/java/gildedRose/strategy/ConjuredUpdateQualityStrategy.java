package gildedRose.strategy;

import gildedRose.Item;

import static gildedRose.ItemUpdater.decrementQualityByOne;
import static gildedRose.ItemUpdater.decrementSellInByOne;
import static gildedRose.ItemValidator.CONJURED;
import static gildedRose.ItemValidator.itemSellDateHasPassed;

public class ConjuredUpdateQualityStrategy implements UpdateQualityStrategy {
    @Override
    public boolean canHandle(String itemName) {
        if (itemName != null) {
            return itemName.contains(CONJURED);
        }
        return false;
    }

    @Override
    public void handle(Item item) {
        decrementQualityByOne(item);
        decrementQualityByOne(item);

        decrementSellInByOne(item);

        if (itemSellDateHasPassed(item)) {
            decrementQualityByOne(item);
            decrementQualityByOne(item);
        }
    }
}
