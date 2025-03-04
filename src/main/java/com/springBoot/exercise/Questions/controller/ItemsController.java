package com.springBoot.exercise.Questions.controller;

import com.springBoot.exercise.Questions.entity.Item;
import com.springBoot.exercise.Questions.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @PostMapping("/save/items")
    public Item saveItems(@RequestBody Item item){
//        System.out.println("adding item");
//        System.out.println(item.getPrice());
        return itemsService.saveItems(item);
    }
}

//    @GetMapping("/get/items")
//    public void getListOfItems(@RequestParam String itemName, @RequestParam int price){
//        System.out.println("adding item");
//        System.out.println(itemName);
//        System.out.println(price);
//    }