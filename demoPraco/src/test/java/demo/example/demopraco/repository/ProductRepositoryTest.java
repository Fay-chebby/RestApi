package demo.example.demopraco.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @Test
    void saveMethod(){
        // CREATE PRODUCT
        Product product =new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ACB");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");
        //save product
       Product savedObject= productRepository.save(product);


       //display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());

    }
    @Test
    void updateUsingSaveMethod() {
        // find or retrieve an entity by id
        Long id = 1L;
        Optional<Product> optionalProduct = productRepository.findById(id);

        // check if the product is present before proceeding with the update
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            // update entity information
            product.setName("updated product 1");
            product.setDescription("updated product 1 desc ");

            // save the updated entity
            productRepository.save(product);
        } else {
            // handle the case where the product with the specified ID is not found
            // throw an exception, log a message, or perform other actions
        }
    }


    @Test
    void findById() {
        Long id = 1L;
        Optional<Product> optionalProduct = productRepository.findById(id);

        // Use ifPresent to perform an action only if the product is present
        optionalProduct.ifPresent(product -> {
            // proceed with the product
        });
    }

    @Test
    void saveAllMethod() {
        // create product
        Product product = new Product();
        product.setName("product 2");
        product.setDescription("product 2 description");
        product.setSku("100ACBD");
        product.setPrice(new BigDecimal(200));
        product.setActive(true);
        product.setImageUrl("product2.png");

        // create another product (product3)
        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("product 3 description");
        product3.setSku("100ACBDE");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        // save both products
        productRepository.saveAll(List.of(product, product3));
    }

    @Test
     void findAllMethod(){
        List<Product> products=productRepository.findAll();
        products.forEach((p)->{
            System.out.println(p.getName());
                }


        );

     }
}