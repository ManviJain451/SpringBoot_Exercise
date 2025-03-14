package com.springBoot.exercise.Questions.repository;

import com.springBoot.exercise.Questions.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {

}
