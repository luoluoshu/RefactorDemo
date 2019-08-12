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
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        GildedRose sut = new GildedRose((Item[]) Arrays.asList(new Item("Sulfuras, Hand of Ragnaros", 0, 80)).toArray());
        sut.updateQuality();
        Assert.assertEquals(sut.getItems()[0].quality, 80);
    }

}