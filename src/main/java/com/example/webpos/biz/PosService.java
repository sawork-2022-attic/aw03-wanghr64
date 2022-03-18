package com.example.webpos.biz;

import com.example.webpos.model.Cart;
import com.example.webpos.model.Product;

import java.util.List;
import java.util.Set;

public interface PosService {
    public Cart getCart();

    public Cart newCart();

    public void checkout(Cart cart);

    public void total(Cart cart);

    public boolean add(Product product, int amount);

    public boolean add(String productId, int amount);

    public boolean delete(String productId);

    public boolean modify(String productId, int amount);

    public void clear();

    public List<Product> products();

    public List<Product> products(String category);

    public Set<String> categories();
}
