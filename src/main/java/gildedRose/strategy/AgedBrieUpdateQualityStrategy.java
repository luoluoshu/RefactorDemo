package gildedRose.strategy;

import gildedRose.Item;

import static gildedRose.ItemUpdater.decrementSellInByOne;
import static gildedRose.ItemUpdater.incrementQualityByOne;
import static gildedRose.ItemValidator.AGED_BRIE;
import static gildedRose.ItemValidator.itemSellDateHasPassed;

public class AgedBrieUpdateQualityStrategy implements UpdateQualityStrategy {
    @Override
    public boolean canHandle(String itemName) {
        return AGED_BRIE.equals(itemName);
    }

    @Override
    public void handle(Item item) {
        incrementQualityByOne(item);
        decrementSellInByOne(item);

        if (itemSellDateHasPassed(item)) {
            incrementQualityByOne(item);
        }
    }
}
