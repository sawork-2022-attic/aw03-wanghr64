package com.example.webpos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String id;
    private String name;
    private double price;
    private String image;
    private String category;

    @Override
    public String toString() {
        return getId() + "\t" + getName() + "\t" + getPrice();
    }

    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((Product) obj).id);
    }

}
