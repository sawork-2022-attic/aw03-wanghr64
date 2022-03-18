package com.example.webpos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private Product product;
    private int quantity;

    @Override
    public String toString() {
        return product.toString() + "\t" + quantity;
    }

    @Override
    public boolean equals(Object obj) {
        return this.product.equals(((Item) obj).product);
    }

    public boolean modify(int num) {
        if (num > 0 || num < 0 && quantity + num >= 0) {
            quantity += num;
            return true;
        } else
            return false;
    }
}
