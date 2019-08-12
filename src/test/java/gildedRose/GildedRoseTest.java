package gildedRose;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class GildedRoseTest {
//    @Before
//    public void initGildedRose(){
//        Item[] items = new Item[];
//        GildedRose gildedRose = new GildedRose(items);
//    }

    @Test
    public void should_return_no_change_given_Sulfuras(){
        GildedRose sut = new GildedRose((Item[]) Arrays
                .asList(new Item("Sulfuras, Hand of Ragnaros", 0, 80)).toArray());
        sut.updateQuality();
        Assert.assertEquals(sut.getItems()[0].quality, 80);
        Assert.assertEquals(sut.getItems()[0].sellIn, 0);
    }

    @Test
    public void should_return_lower_the_sellIn_and_quality_when_by_one_given_normal_items(){
        GildedRose sut = new GildedRose((Item[]) Arrays.
                asList(new Item("Normal", 3, 12)).toArray());
        sut.updateQuality();
        Assert.assertEquals(sut.getItems()[0].quality, 11);
        Assert.assertEquals(sut.getItems()[0].sellIn, 2);
    }

    @Test
    public void should_return_lower_the_sellIn_and_quality_when_by_one_given_normal_items_sellIn_negative(){
        GildedRose sut = new GildedRose((Item[]) Arrays.
                asList(new Item("Normal", 0, 12)).toArray());
        sut.updateQuality();
        Assert.assertEquals(sut.getItems()[0].quality, 10);
        Assert.assertEquals(sut.getItems()[0].sellIn, -1);
    }

    @Test
    public void should_return_lower_the_sellIn_and_higher_quality_when_by_one_given_Aged_Brie_items(){
        GildedRose sut = new GildedRose((Item[]) Arrays.
                asList(new Item("Aged Brie", 3, 12)).toArray());
        sut.updateQuality();
        Assert.assertEquals(sut.getItems()[0].quality, 13);
        Assert.assertEquals(sut.getItems()[0].sellIn, 2);
    }

    @Test
    public void should_return_lower_the_sellIn_and_higher_quality_when_by_one_given_Aged_Brie_items_sellIn_negative(){
        GildedRose sut = new GildedRose((Item[]) Arrays.
                asList(new Item("Aged Brie", -2, 12)).toArray());
        sut.updateQuality();
        Assert.assertEquals(sut.getItems()[0].quality, 14);
        Assert.assertEquals(sut.getItems()[0].sellIn, -3);
    }

    @Test
    public void should_return_lower_the_sellIn_and_higher_quality_when_by_one_given_Aged_Brie_items_quality_50(){
        GildedRose sut = new GildedRose((Item[]) Arrays.
                asList(new Item("Aged Brie", -2, 50)).toArray());
        sut.updateQuality();
        Assert.assertEquals(sut.getItems()[0].quality, 50);
        Assert.assertEquals(sut.getItems()[0].sellIn, -3);
    }

    @Test
    public void should_return_lower_the_sellIn_and_quality_when_by_one_given_Backstage_passes_to_a_TAFKAL80ETC_concert_items(){
        GildedRose sut = new GildedRose((Item[]) Arrays.
                asList(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 12)).toArray());
        sut.updateQuality();
        Assert.assertEquals(sut.getItems()[0].quality, 13);
        Assert.assertEquals(sut.getItems()[0].sellIn, 10);
    }

    @Test
    public void should_return_lower_the_sellIn_and_quality_when_by_one_given_Backstage_passes_to_a_TAFKAL80ETC_concert_items_sellIn_10(){
        GildedRose sut = new GildedRose((Item[]) Arrays.
                asList(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 12)).toArray());
        sut.updateQuality();
        Assert.assertEquals(sut.getItems()[0].quality, 14);
        Assert.assertEquals(sut.getItems()[0].sellIn, 9);
    }

    @Test
    public void should_return_lower_the_sellIn_and_quality_when_by_one_given_Backstage_passes_to_a_TAFKAL80ETC_concert_items_sellIn_5(){
        GildedRose sut = new GildedRose((Item[]) Arrays.
                asList(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 12)).toArray());
        sut.updateQuality();
        Assert.assertEquals(sut.getItems()[0].quality, 15);
        Assert.assertEquals(sut.getItems()[0].sellIn, 4);
    }

    @Test
    public void should_return_lower_the_sellIn_and_quality_when_by_one_given_Backstage_passes_to_a_TAFKAL80ETC_concert_items_sellIn_0(){
        GildedRose sut = new GildedRose((Item[]) Arrays.
                asList(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 12)).toArray());
        sut.updateQuality();
        Assert.assertEquals(sut.getItems()[0].quality, 0);
        Assert.assertEquals(sut.getItems()[0].sellIn, -1);
    }
}