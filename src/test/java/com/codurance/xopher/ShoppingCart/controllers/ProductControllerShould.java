package com.codurance.xopher.ShoppingCart.controllers;

import com.codurance.xopher.ShoppingCart.models.Product;
import com.codurance.xopher.ShoppingCart.repositories.Repository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductControllerShould {

    @Test
    public void returnViewWithProduct() {

        List<Product> expectedProducts = getProducts();

        Repository repository = mock(Repository.class);
        when(repository.getAll()).thenReturn(getProducts());
        ProductController controller = new ProductController(repository);

        ModelAndView actual = controller.index();
        List<Product> products = (List<Product>) actual.getModel().get("products");


        Assert.assertEquals(expectedProducts, products);
    }

    @Test
    public void returnViewIndex() {

        Repository repository = mock(Repository.class);
        when(repository.getAll()).thenReturn(getProducts());
        ProductController controller = new ProductController(repository);

        ModelAndView actual = controller.index();

        Assert.assertEquals("index", actual.getViewName());
    }

    private List<Product> getProducts() {
        Product lotr = new Product("Lord of the Rings", "10001", new BigDecimal("10.00"), "BOOK");
        Product hobbit = new Product("The Hobbit", "10002", new BigDecimal("5.00"), "BOOK");
        Product got = new Product("Game of Thrones", "20001", new BigDecimal("9.00"), "DVD");
        Product breakingBad = new Product("Breaking Bad", "20110", new BigDecimal("7.00"), "DVD");

        return Arrays.asList(lotr, hobbit, got, breakingBad);
    }
}
