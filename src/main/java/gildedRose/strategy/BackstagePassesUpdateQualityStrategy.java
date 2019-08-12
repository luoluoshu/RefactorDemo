package gildedRose.strategy;

import gildedRose.Item;

import static gildedRose.ItemUpdater.decrementSellInByOne;
import static gildedRose.ItemUpdater.incrementQualityByOne;
import static gildedRose.ItemUpdater.setQualityToZero;
import static gildedRose.ItemValidator.BACKSTAGE_PASSES;
import static gildedRose.ItemValidator.itemSellDateHasPassed;

public class BackstagePassesUpdateQualityStrategy implements UpdateQualityStrategy {

    public static final int FIRST_SIZE = 11;
    public static final int SECOND_SIZE = 6;

    @Override
    public boolean canHandle(String itemName) {
        return BACKSTAGE_PASSES.equals(itemName);
    }

    @Override
    public void handle(Item item) {
        incrementQualityByOne(item);

        if (item.sellIn < FIRST_SIZE) {
            incrementQualityByOne(item);
        }

        if (item.sellIn < SECOND_SIZE) {
            incrementQualityByOne(item);
        }

        decrementSellInByOne(item);

        if (itemSellDateHasPassed(item)) {
            setQualityToZero(item);
        }
    }
}
