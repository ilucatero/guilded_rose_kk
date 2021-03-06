package com.gildedrose.core;

import com.gildedrose.core.service.QualityManagerService;
import com.gildedrose.core.model.Item;

import java.util.Arrays;

/**
 * This class works and should only be taken as reference to legacy functionality. <br>
 *     To see the newest functionality go check the unit tests
 */
public class GoldenMasterMain {
    public static void main(String[] args) {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            // the following items do not work properly yet
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Conjured Mana Cake", 3, 6) };

        int days = 20;

        QualityManagerService qualityManagerService = new QualityManagerService();
        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            qualityManagerService.updateQuality(Arrays.asList(items));
        }
    }
}
