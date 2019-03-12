package com.gildedrose.core.service;

import com.gildedrose.core.dao.Dao;
import com.gildedrose.core.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    protected Dao<Item> itemDao;

    @Autowired
    QualityManagerService qualityManagerService;

    public List<Item> getItems(){
        return itemDao.getAll();
    }

    public boolean degrade(Long id){
        // TODO: add the required functionality
        Optional<Item> opItem = itemDao.get(id);
        if (opItem.isPresent() ) {
            qualityManagerService.updateQuality(new Item[]{opItem.get()});
            return true;
        }
        return false;
    }
}