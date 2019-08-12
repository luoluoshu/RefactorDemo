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

}