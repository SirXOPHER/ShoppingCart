package com.codurance.xopher.ShoppingCart.repositories;

import com.codurance.xopher.ShoppingCart.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository implements Repository<Product> {

    @Override
    public List<Product> getAll() {
        return new ArrayList<>();
    }
}
