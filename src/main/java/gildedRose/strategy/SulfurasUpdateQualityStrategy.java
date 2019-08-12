package gildedRose.strategy;

import gildedRose.Item;

import static gildedRose.ItemUpdater.decrementSellInByOne;
import static gildedRose.ItemUpdater.incrementQualityByOne;
import static gildedRose.ItemValidator.AGED_BRIE;
import static gildedRose.ItemValidator.SULFURAS;
import static gildedRose.ItemValidator.itemSellDateHasPassed;

public class SulfurasUpdateQualityStrategy implements UpdateQualityStrategy  {
    @Override
    public boolean canHandle(String itemName) {
        return SULFURAS.equals(itemName);
    }

    @Override
    public void handle(Item item) {
    }
}
