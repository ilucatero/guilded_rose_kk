package com.gildedrose.web.controller;

import com.guildedrose.core.model.Item;
import com.guildedrose.core.service.ItemService;

import java.util.List;

public class ItemController {

    // TODO: replace it with the spring bean
    ItemService itemService = new ItemService();

    public List<Item> getItems(){
        return itemService.getItems();
    }

}
