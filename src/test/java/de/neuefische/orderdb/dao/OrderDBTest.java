package de.neuefische.orderdb.dao;

import de.neuefische.orderdb.model.Order;
import de.neuefische.orderdb.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderDBTest {

    @Test
    public void testAddOrder(){
        // Given
        OrderDB orderDB = new OrderDB();
        List<Product> products = List.of(
                new Product("product#1", "A sweet product"),
                new Product("product#2", "Another sweet product"),
                new Product("product#3", "And one more sweet product")
        );
        Order order = new Order("order#1", products);
        orderDB.addOrder(order);

        // When
        Optional<Order> actual = orderDB.getOrderById("order#1");

        // Then
        Order expectedOrder = new Order("order#1", List.of(
                new Product("product#1", "A sweet product"),
                new Product("product#2", "Another sweet product"),
                new Product("product#3", "And one more sweet product")
        ));
        assertEquals(expectedOrder, actual.get());
    }

    @Test
    public void testListOrdersListsAllOrders(){
        // Given
        OrderDB orderDB = new OrderDB();
        orderDB.addOrder(new Order("order#1", List.of(new Product("product#1", "A sweet product"))));
        orderDB.addOrder(new Order("order#2", List.of(
                new Product("product#1", "A sweet product"),
                new Product("product#2", "Another sweet product"))
        ));

        // When
        List<Order> actual = orderDB.listOrders();

        // Then
        Order expectedOrder1 = new Order("order#1", List.of(new Product("product#1", "A sweet product")));
        Order expectedOrder2 = new Order("order#2", List.of(
                new Product("product#1", "A sweet product"),
                new Product("product#2", "Another sweet product")
        ));

        assertEquals(2, actual.size());
        assertTrue(actual.contains(expectedOrder1));
        assertTrue(actual.contains(expectedOrder2));

    }

}