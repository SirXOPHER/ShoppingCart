package integration;

import com.codurance.xopher.ShoppingCart.ShoppingCartApplication;
import com.codurance.xopher.ShoppingCart.controllers.ProductController;
import com.codurance.xopher.ShoppingCart.models.Product;
import com.codurance.xopher.ShoppingCart.repositories.Repository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ActiveProfiles("test")
@ContextConfiguration(classes = {ShoppingCartApplication.class})
public class ProductControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webContext;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .webAppContextSetup(webContext)
                .build();
    }

    @Test
    public void returnViewWithProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/?products=true"))
                .andExpect(model().attribute("products", getProducts()));
    }

    @Test
    public void returnViewIndex() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/?products=true"))
                .andExpect(view().name("index"));
    }

    @Test
    public void returnViewWithoutProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/?products=false"))
                .andExpect(model().attributeDoesNotExist("products"));
    }

    private List<Product> getProducts() {
        Product lotr = new Product("Lord of the Rings", "10001", new BigDecimal("10.00"), "BOOK");
        Product hobbit = new Product("The Hobbit", "10002", new BigDecimal("5.00"), "BOOK");
        Product got = new Product("Game of Thrones", "20001", new BigDecimal("9.00"), "DVD");
        Product breakingBad = new Product("Breaking Bad", "20110", new BigDecimal("7.00"), "DVD");

        return Arrays.asList(lotr, hobbit, got, breakingBad);
    }
}
