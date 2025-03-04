package com.springBoot.exercise.Questions.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Table(name = "Shop")
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonProperty("Item_Name")
    private String itemName;

    @Column
    @JsonProperty("Item_Price")
    private Long price;

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public Long getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
