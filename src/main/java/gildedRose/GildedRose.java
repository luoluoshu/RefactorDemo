package gildedRose;

import gildedRose.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {
    Item[] items;
//    List<Item> itemList = new ArrayList<>();
private static List<UpdateQualityStrategy> updateQualityStrategies = new ArrayList<>();

    static {
        updateQualityStrategies.add(new AgedBrieUpdateQualityStrategy());
        updateQualityStrategies.add(new BackstagePassesUpdateQualityStrategy());
        updateQualityStrategies.add(new DefaultUpdateQualityStrategy());
        updateQualityStrategies.add(new SulfurasUpdateQualityStrategy());
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityStrategies.stream()
                    .filter(strategy -> strategy.canHandle(item.name))
                    .forEach(strategy -> strategy.handle(item));
        }
    }


    private void noSulfurasQualitySubOne(Item item) {
        if (item.quality > ItemValidator.MINIMUM_ITEM_QUALITY) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void noSulfurasSellInSubOne(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void addBackstageQuality(Item item) {
        if (item.sellIn < 11) {
            addItemQuality(item);
        }

        if (item.sellIn < 6) {
            addItemQuality(item);
        }
    }

    private void addItemQuality(Item item) {
        if (item.quality < ItemValidator.MAXIMUM_ITEM_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    private boolean isAgedBrieAndBackstagePass(Item item) {
        return item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }
}