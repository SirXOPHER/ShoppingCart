package com.codurance.xopher.ShoppingCart.repositories;

import java.util.List;

public interface Repository<T> {

    List<T> getAll();
}
