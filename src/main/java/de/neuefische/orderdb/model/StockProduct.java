package de.neuefische.orderdb.model;

import java.util.Objects;

public class StockProduct implements Product {

    private String name;
    private String id;

    public StockProduct(String id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockProduct product = (StockProduct) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
