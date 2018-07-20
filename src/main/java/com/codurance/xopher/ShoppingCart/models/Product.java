package com.codurance.xopher.ShoppingCart.models;

import java.math.BigDecimal;

public class Product {

    private final String name;

    private final String sku;
    private final BigDecimal value;
    private final String type;
    public Product(String name, String sku, BigDecimal value, String type) {

        this.name = name;
        this.sku = sku;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (sku != null ? !sku.equals(product.sku) : product.sku != null) return false;
        if (value != null ? !value.equals(product.value) : product.value != null) return false;
        return type != null ? type.equals(product.type) : product.type == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (sku != null ? sku.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
