package com.onlinetutorialspoint.controller;

import com.onlinetutorialspoint.model.Item;
import com.onlinetutorialspoint.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepo;

    @RequestMapping("/getAllItems")
    public List<Item> getAllItems() {
        return itemRepo.getAllItems();
    }

    @RequestMapping("/getAllItemsName")
    public List<String> getAllItemsName() {
        return itemRepo.getAllItemsNames();
    }

    @RequestMapping("/getItem")
    public Item getItem(@RequestParam("itemId") int itemId) {
        return itemRepo.getItem(itemId);
    }

    @RequestMapping("/addItem")
    public String addItem(@RequestParam("id") int id, @RequestParam("name") String name,
                          @RequestParam("category") String category) {
        if (itemRepo.addItem(id, name, category) >= 1) {
            return "Item Added Successfully";
        } else {
            return "Something went wrong !";
        }
    }

    @RequestMapping("/deteteItem")
    public String deleteItem(@RequestParam("itemId") int itemId) {
        if (itemRepo.deleteItem(itemId) >= 1) {
            return "Item Deleted Successfully";
        } else {
            return "Something went wrong !";
        }
    }
}