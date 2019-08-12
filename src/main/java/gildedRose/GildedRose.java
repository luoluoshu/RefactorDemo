package gildedRose;

import gildedRose.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {
    Item[] items;
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

}