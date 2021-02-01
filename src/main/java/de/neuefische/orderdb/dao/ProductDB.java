package de.neuefische.orderdb.dao;

import de.neuefische.orderdb.model.Product;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductDB {
    private final List<Product> products;

    public ProductDB(List<Product> products) {
        this.products = products;
    }

    public List<Product> listProducts() {
        return Collections.unmodifiableList(products);
    }

    public Optional<Product> getProductById(String id) {
        for(Product product: products){
            if(product.getId().equals(id)){
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }
}
