package com.itemapi.apiItems.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itemapi.apiItems.model.Item;
import com.itemapi.apiItems.respository.ItemRepository;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class ItemController {
    
    @Autowired // indica que a propriedade itemRepository deve ser injetada automaticamente
    ItemRepository itemRepository;

    @GetMapping("/items/{id}")
    Item findByItem(@PathVariable Integer id) {
        return itemRepository.findById(id).get();
    }

    @GetMapping("/items")
    List<Item> all() {
        return itemRepository.findAll();
    }

    @PostMapping("/items")
    Item save(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @DeleteMapping("/items/{id}")
    void delete(@PathVariable Integer id) {
        itemRepository.deleteById(id);
    }

    @PutMapping("/items/{id}")
    Item updateOrCreate(@RequestBody Item newItem, @PathVariable Integer id) {
        return itemRepository.findById(id)
            .map(item -> {
                item.setName(newItem.getName());
                return itemRepository.save(item);
            })
            .orElseGet(
                () -> {
                    newItem.setId(id);
                    return itemRepository.save(newItem);
                }
            );
    }
    

}
