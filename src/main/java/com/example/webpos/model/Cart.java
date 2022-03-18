package com.example.webpos.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.apache.tomcat.util.http.fileupload.MultipartStream.ItemInputStream;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    public boolean addItem(Item item) {
        for (Item i : items) {
            if (i.equals(item)) {
                i.modify(item.getQuantity());
                return true;
            }
        }
        return items.add(item);
    }

    public boolean deleteItem(Item item) {
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            Item i = it.next();
            if (i.equals(item)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean modifyItem(Item item) {
        for (Item i : items) {
            if (i.equals(item)) {
                boolean flag = i.modify(item.getQuantity());
                if (flag == false)
                    return flag;
                if (i.getQuantity() == 0)
                    return deleteItem(item);
            }
        }
        return false;
    }

    public double total() {
        double res = 0;
        for (Item i : items) {
            res += i.getProduct().getPrice() * i.getQuantity();
        }
        return res;
    }

    public void clear() {
        items.clear();
    }

    @Override
    public String toString() {
        if (items.size() == 0) {
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n");

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(items.get(i).toString()).append("\n");
            total += items.get(i).getQuantity() * items.get(i).getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n");

        stringBuilder.append("Total...\t\t\t" + total);

        return stringBuilder.toString();
    }
}
