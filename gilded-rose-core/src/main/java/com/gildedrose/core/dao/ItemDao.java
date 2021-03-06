package com.gildedrose.core.dao;

import com.gildedrose.core.model.Item;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ItemDao extends AbstractJpaDAO<Item>{

    public ItemDao(){
        setClazz(Item.class);
    }

    public List<Item> find(List<Long> ids) {
        return findSome(ids);
    }

    public Optional<Item> get(Long id) {
        return Optional.of(findOne(id));
    }

    public List<Item> getAll() {
        return findAll();
    }

    public Item update(Item item, String[] params) {
        Optional<Item> itemOptional = get(item.id);
        if (itemOptional.isPresent()) {
            Item updateItem = itemOptional.get();
            for (String param : params) {
                switch (param) {
                    case "name":
                        updateItem.name = item.name;
                        break;
                    case "sellIn":
                        updateItem .sellIn = item.sellIn;
                        break;
                    case "quality":
                        updateItem .quality = item.quality;
                        break;
                    default:
                }
            }
            return update(updateItem );
        }
        return null;
    }


    @Override
    public Item save(Item item) {
        create(item);
        return item;
    }

    @Override
    public <S extends Item> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Item> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Item> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void deleteAll(Iterable<? extends Item> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
