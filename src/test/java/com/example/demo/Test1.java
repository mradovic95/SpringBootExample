package com.example.demo;

import com.example.demo.domain.Contact;
import com.example.demo.domain.Product;
import com.example.demo.domain.User;
import com.example.demo.repositories.ContactRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test1 {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
        productRepository.deleteAll();
    }


    @Test
    public void createUserWithProductsServiceTest() {

        assertThat(userRepository.count()).isEqualTo(0);
        assertThat(productRepository.count()).isEqualTo(0);

        User user = new User();
        user.setAge(25);
        user.setFirstName("user1");
        user.setLastName("user1");
        Product product1 = new Product();
        product1.setTitle("product1");
        product1.setPrice(100);
        product1.setDescription("descripton");
        Product product2 = new Product();
        product2.setTitle("product2");
        product2.setPrice(200);
        product2.setDescription("description");
        user.getProducts().add(product1);
        user.getProducts().add(product2);

        userRepository.save(user);

        assertThat(userRepository.count()).isEqualTo(1);
        assertThat(productRepository.count()).isEqualTo(2);


    }

    @Test
    public void createUserWithContactsServiceOrphanRemoveTest() {

        assertThat(userRepository.count()).isEqualTo(0);
        assertThat(contactRepository.count()).isEqualTo(0);

        User user = new User();
        user.setAge(25);
        user.setFirstName("user1");
        user.setLastName("user1");
        Contact contact1 = new Contact();
        contact1.setValue("011/313-2123-123123-123123");
        Contact contact2 = new Contact();
        contact2.setValue("011/313-2323-123123-123123");
        user.getContacts().add(contact1);
        user.getContacts().add(contact2);


        userRepository.save(user);

        assertThat(userRepository.count()).isEqualTo(1);
        assertThat(contactRepository.count()).isEqualTo(2);

        user.getContacts().clear();
        userRepository.save(user);
        assertThat(contactRepository.count()).isEqualTo(0);


    }


}
