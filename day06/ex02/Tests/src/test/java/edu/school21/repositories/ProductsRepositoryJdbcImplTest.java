package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ProductsRepositoryJdbcImplTest {

    ProductsRepository productsRepository;
    EmbeddedDatabase db;

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(1L, "Gleb", 21),
            new Product(2L, "Fish", 745),
            new Product(3L, "Note", 20),
            new Product(4L, "You", 1),
            new Product(5L, "God", 33)
            );
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(5L, "God", 33);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(4L, "We", 121);
    final Product EXPECTED_SAVE_PRODUCT = new Product(6L, "Book", 5000);

    @BeforeEach
    void init() {
        db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).addScript("schema.sql").addScript("data.sql").build();
        productsRepository = new ProductsRepositoryJdbcImpl(db);
    }

    @Test
    void testFindAll() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, productsRepository.findAll());
    }

    @Test
    void testFindById() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, productsRepository.findById(2L).get());
    }

    @Test
    void testUpdate() throws SQLException {
        productsRepository.update(EXPECTED_UPDATED_PRODUCT);
        Assertions.assertEquals(EXPECTED_UPDATED_PRODUCT, productsRepository.findById(3L).get());
    }

    @Test
    void testSave() throws SQLException {
        productsRepository.save(EXPECTED_SAVE_PRODUCT);
        Assertions.assertEquals(EXPECTED_SAVE_PRODUCT, productsRepository.findById(6L).get());
    }

    @Test
    void testDelete() throws SQLException {
        productsRepository.delete(1L);
        Assertions.assertThrows(RuntimeException.class, () -> productsRepository.findById(1L));
    }

    @AfterEach
    void close() {
        db.shutdown();
    }

}
