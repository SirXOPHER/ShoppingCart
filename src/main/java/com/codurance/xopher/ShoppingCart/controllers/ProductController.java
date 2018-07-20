package com.codurance.xopher.ShoppingCart.controllers;

import com.codurance.xopher.ShoppingCart.models.Product;
import com.codurance.xopher.ShoppingCart.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    private Repository<Product> repository;

    @Autowired
    public ProductController(Repository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public ModelAndView index() {

        List<Product> products = repository.getAll();

        ModelAndView result = new ModelAndView("index");
        result.addObject("products", products);

        return result;
    }
}
