package gildedRose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {
    Item[] items;
//    List<Item> itemList = new ArrayList<>();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!isAgedBrieAndBackstagePass(items[i])) {
                if (items[i].quality > 0) {
                    noSulfurasQualitySubOne(items[i]);
                }
            } else {
                if (items[i].quality < 50) {
                    addItemQuality(items[i]);

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        addBackstageQuality(items[i]);
                    }
                }
            }

            noSulfurasSellInSubOne(items[i]);

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            noSulfurasQualitySubOne(items[i]);
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    addItemQuality(items[i]);
                }
            }
        }
    }

    private void noSulfurasQualitySubOne(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = item.quality - 1;
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
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private boolean isAgedBrieAndBackstagePass(Item item) {
        return item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }
}