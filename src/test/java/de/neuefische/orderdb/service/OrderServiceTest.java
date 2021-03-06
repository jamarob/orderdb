package de.neuefische.orderdb.service;

import de.neuefische.orderdb.dao.OrderDB;
import de.neuefische.orderdb.dao.ProductDB;
import de.neuefische.orderdb.model.OnDemandProduct;
import de.neuefische.orderdb.model.Order;
import de.neuefische.orderdb.model.StockProduct;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    public void testOrderProducts(){
        // Given
        ProductDB productDB = new ProductDB(List.of(
                new StockProduct("product#1", "A sweet product"),
                new StockProduct("product#2", "Another sweet product"),
                new OnDemandProduct("product#3", "And one more sweet product", Duration.ofDays(2))
        ));
        OrderDB orderDB = new OrderDB();
        OrderService orderService = new OrderService(productDB, orderDB);
        List<String> productIdsToOrder = List.of("product#1", "product#3");

        // When
        Order order = orderService.orderProducts(productIdsToOrder);

        // Then
        assertNotNull(order.getId());
        assertNotEquals("", order.getId());
        assertEquals(2, order.getProducts().size());
        assertTrue(order.getProducts().contains(new StockProduct("product#1", "A sweet product")));
        assertTrue(order.getProducts().contains( new OnDemandProduct("product#3", "And one more sweet product", Duration.ofDays(2))));
    }

    @Test
    public void testThrowsWhenOrderingProductsThatAreNotInTheDB(){
        // Given
        ProductDB productDB = new ProductDB(List.of(
                new StockProduct("product#1", "A sweet product"),
                new StockProduct("product#2", "Another sweet product"),
                new StockProduct("product#3", "And one more sweet product")
        ));
        OrderDB orderDB = new OrderDB();
        OrderService orderService = new OrderService(productDB, orderDB);

        List<String> productIdsToOrder = List.of("product#42", "product#1");

        // When
        try {
            orderService.orderProducts(productIdsToOrder);
            fail("Exception not thrown");
        }catch(Exception e){
            // Then
            assertEquals(IllegalArgumentException.class, e.getClass());
            assertEquals("Product id not found: product#42", e.getMessage());
        }

    }
}