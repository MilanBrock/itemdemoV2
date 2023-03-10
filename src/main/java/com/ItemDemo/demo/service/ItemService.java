package com.ItemDemo.demo.service;

import com.ItemDemo.demo.dao.ItemRepository;
import com.ItemDemo.demo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(Item item){
        return itemRepository.save(item);
    }

    public List<Item> createItems(List<Item> items){
        return itemRepository.saveAll(items);
    }

    public Item getItemById(int id){
        return itemRepository.findById(id).orElse(null);
    }

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public Item updateItem (Item item){
        Item oldItem = new Item();
        Optional<Item> optionalItem = itemRepository.findById(item.getId());
        if(optionalItem.isPresent()){
            oldItem = optionalItem.get();
            oldItem.setName(item.getName());
            oldItem.setDescription(item.getDescription());
            itemRepository.save(oldItem);
        } else {
            return new Item();
        }
        return oldItem;
    }

    public String deleteItemById(int id){
        itemRepository.deleteById(id);
        return "Item got deleted";
    }


}
