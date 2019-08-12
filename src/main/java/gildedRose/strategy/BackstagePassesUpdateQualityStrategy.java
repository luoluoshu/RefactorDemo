package gildedRose.strategy;

import gildedRose.Item;

import static gildedRose.ItemUpdater.decrementSellInByOne;
import static gildedRose.ItemUpdater.incrementQualityByOne;
import static gildedRose.ItemUpdater.setQualityToZero;
import static gildedRose.ItemValidator.BACKSTAGE_PASSES;
import static gildedRose.ItemValidator.itemSellDateHasPassed;

public class BackstagePassesUpdateQualityStrategy implements UpdateQualityStrategy {
    @Override
    public boolean canHandle(String itemName) {
        return BACKSTAGE_PASSES.equals(itemName);
    }

    @Override
    public void handle(Item item) {
        incrementQualityByOne(item);

        if (item.sellIn < 11) {
            incrementQualityByOne(item);
        }

        if (item.sellIn < 6) {
            incrementQualityByOne(item);
        }

        decrementSellInByOne(item);

        if (itemSellDateHasPassed(item)) {
            setQualityToZero(item);
        }
    }
}
