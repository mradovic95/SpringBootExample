package com.example.demo.services;

import com.example.demo.domain.Order;
import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ProductService extends CrudService<Product, Integer, ProductRepository> {

    private RestTemplate restTemplate;

    @Value("${orders.baseUrl}")
    private String ordersBaseUrl;

    public ProductService(ProductRepository repository, RestTemplate restTemplate) {
        super(repository);
        this.restTemplate = restTemplate;
    }

    public void buyProduct(int productId, int count) {
        Optional<Product> product = getRepository().findById(productId);
        if (!product.isPresent()) {
            return;
        }
        Order order = new Order(product.get(), count);

        System.out.println(order.getCount());
        restTemplate.postForEntity(ordersBaseUrl + "/order", order, Order.class);


    }


}
