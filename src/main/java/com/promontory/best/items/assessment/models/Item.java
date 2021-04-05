package com.promontory.best.items.assessment.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {

    private String itemName;
    private double price;

    @Override
    public String toString() {
        return this.itemName + " " + this.price;
    }
}
