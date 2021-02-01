package de.neuefische.orderdb.dao;

import de.neuefische.orderdb.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductDBTest {

    @Test
    public void testContainsAllTheProducts(){
        // Given
        List<Product> products = List.of(
                new Product("product#1", "A sweet product"),
                new Product("product#2", "Another sweet product"),
                new Product("product#3", "And one more sweet product")
        );
        ProductDB productDB = new ProductDB(products);

        // When
        List<Product> actual = productDB.listProducts();

        // Then
        assertEquals(3, actual.size());
        assertTrue(actual.contains(new Product("product#1", "A sweet product")));
        assertTrue(actual.contains(new Product("product#2", "Another sweet product")));
        assertTrue(actual.contains(new Product("product#3", "And one more sweet product")));
    }

    @Test
    public void testGetReturnsOptionalWithTheProduct(){
        // Given
        List<Product> products = List.of(
                new Product("product#1", "A sweet product"),
                new Product("product#2", "Another sweet product"),
                new Product("product#3", "And one more sweet product")
        );
        ProductDB productDB = new ProductDB(products);

        // When
        Optional<Product> actual = productDB.getProductById("product#2");

        // Then
        assertEquals(new Product("product#2", "Another sweet product"), actual.get());
    }

    @Test
    public void testGetReturnsEmptyOptionalForUnknownId(){
        // Given
        List<Product> products = List.of(
                new Product("product#1", "A sweet product"),
                new Product("product#2", "Another sweet product"),
                new Product("product#3", "And one more sweet product")
        );
        ProductDB productDB = new ProductDB(products);

        // When
        Optional<Product> actual = productDB.getProductById("product#42");

        // Then
        assertTrue(actual.isEmpty());
    }
}