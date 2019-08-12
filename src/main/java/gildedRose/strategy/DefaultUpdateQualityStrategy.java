package gildedRose.strategy;

import gildedRose.Item;

import static gildedRose.ItemUpdater.decrementQualityByOne;
import static gildedRose.ItemUpdater.decrementSellInByOne;
import static gildedRose.ItemValidator.isSpecialItem;
import static gildedRose.ItemValidator.itemSellDateHasPassed;

public class DefaultUpdateQualityStrategy implements UpdateQualityStrategy  {
    @Override
    public boolean canHandle(String itemName) {
        return !isSpecialItem(itemName);
    }

    @Override
    public void handle(Item item) {
        decrementQualityByOne(item);
        decrementSellInByOne(item);

        if (itemSellDateHasPassed(item)) {
            decrementQualityByOne(item);
        }
    }
}
