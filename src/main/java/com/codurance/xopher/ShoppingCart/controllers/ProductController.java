package com.codurance.xopher.ShoppingCart.controllers;

import com.codurance.xopher.ShoppingCart.models.Product;
import com.codurance.xopher.ShoppingCart.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView index(@RequestParam(value = "products", defaultValue = "false") boolean showProducts) {

        ModelAndView result = new ModelAndView("index");

        if (showProducts) {
            List<Product> products = repository.getAll();
            result.addObject("products", products);
        }

        return result;
    }
}
