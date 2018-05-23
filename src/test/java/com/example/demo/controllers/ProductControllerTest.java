package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() {
        productRepository.deleteAll();
    }

    @Test
    public void testGettingAllProducts() {

        Product product = new Product();
        product.setTitle("product1");
        product.setDescription("desription");
        product.setPrice(100);
        productRepository.save(product);

        ResponseEntity<PagedResources<Product>> response = restTemplate.exchange("/product",
                HttpMethod.GET, null, new ParameterizedTypeReference<PagedResources<Product>>() {
                });
        System.out.println(response);
        List<Product> products = new ArrayList<>(response.getBody().getContent());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(products.size()).isEqualTo(1);
        assertThat(products.get(0).getPrice()).isEqualTo(100);
    }

    @Test
    public void testGettingProductById() {


        int id = 1;

        Product product = new Product();
        product.setProductId(id);
        product.setTitle("product1");
        product.setDescription("desription");
        product.setPrice(100);
        productRepository.save(product);


        ResponseEntity<Product> response = restTemplate.getForEntity(String.format("/product/%d", id), Product.class);
        System.out.println(response);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getPrice()).isEqualTo(100);
        assertThat(response.getBody().getTitle()).isEqualTo("product1");
    }

    @Test
    public void testAddingProduct() {


        assertThat(productRepository.count()).isEqualTo(0);

        Product product = new Product();
        product.setProductId(1);
        product.setTitle("product1");
        product.setDescription("desription");
        product.setPrice(100);

        ResponseEntity<Object> response = restTemplate.postForEntity("/product", product, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);


        assertThat(productRepository.count()).isEqualTo(1);

    }

    @Test
    public void testDeletingProduct() {


        Product product = new Product();
        product.setProductId(1);
        product.setTitle("product1");
        product.setDescription("desription");
        product.setPrice(100);
        productRepository.save(product);

        assertThat(productRepository.count()).isEqualTo(1);

        restTemplate.delete(String.format("/product/%d", 1));


        assertThat(productRepository.count()).isEqualTo(0);

    }


}
