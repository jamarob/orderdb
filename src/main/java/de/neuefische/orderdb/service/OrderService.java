package de.neuefische.orderdb.service;

import de.neuefische.orderdb.dao.OrderDB;
import de.neuefische.orderdb.dao.ProductDB;
import de.neuefische.orderdb.model.Order;
import de.neuefische.orderdb.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderService {
    private final ProductDB productDB;
    private final OrderDB orderDB;

    public OrderService(ProductDB productDB, OrderDB orderDB) {
        this.productDB = productDB;
        this.orderDB = orderDB;
    }

    public Order orderProducts(List<String> productIdsToOrder) {
        List<Product> productsToOrder = new ArrayList<>();
        for(String id: productIdsToOrder){
            Optional<Product> optionalProduct = productDB.getProductById(id);
            if(optionalProduct.isPresent()){
                productsToOrder.add(optionalProduct.get());
            }else{
                throw new IllegalArgumentException("Product id not found: "+id);
            }
        }
        String id = UUID.randomUUID().toString();
        Order order = new Order(id, productsToOrder);
        return order;
    }
}
