package com.codurance.xopher.ShoppingCart.repositories;

import com.codurance.xopher.ShoppingCart.models.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProductRepository implements Repository<Product> {

    private JdbcTemplate template;

    public ProductRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Product> getAll() {
        List<Map<String, Object>> productResultSet = template.queryForList("SELECT * FROM Products");

        return productResultSet.stream().map(products -> getProduct(products)).collect(Collectors.toList());
    }

    private Product getProduct(Map<String, Object> productResultSet) {
        String name = (String) productResultSet.get("name");
        String sku = (String) productResultSet.get("sku");
        BigDecimal value = (BigDecimal) productResultSet.get("value");
        String type = (String) productResultSet.get("type");

        return new Product(name, sku, value, type);
    }
}
