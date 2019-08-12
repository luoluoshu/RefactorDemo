package gildedRose.strategy;

import gildedRose.Item;

public interface UpdateQualityStrategy {

    boolean canHandle(String itemName);

    void handle(Item item);
}
