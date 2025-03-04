package com.springBoot.exercise.Questions.service;

import com.springBoot.exercise.Questions.entity.Item;
import com.springBoot.exercise.Questions.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    public Item saveItems(Item item){
        return itemsRepository.save(item);
    }
}
