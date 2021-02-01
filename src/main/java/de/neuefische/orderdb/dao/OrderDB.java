package de.neuefische.orderdb.dao;

import de.neuefische.orderdb.model.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OrderDB {

    private List<Order> orders;

    public OrderDB(){
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Optional<Order> getOrderById(String id){
        for(Order order: orders){
            if(order.getId().equals(id)){
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    public List<Order> listOrders() {
        return Collections.unmodifiableList(orders);
    }
}
