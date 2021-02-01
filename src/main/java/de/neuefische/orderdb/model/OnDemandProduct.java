package de.neuefische.orderdb.model;

import java.time.Duration;
import java.util.Objects;

public class OnDemandProduct implements Product{

    private String id;
    private String name;
    private Duration productionTime;

    public OnDemandProduct(String id, String name, Duration productionTime) {
        this.id = id;
        this.name = name;
        this.productionTime = productionTime;
    }

    public Duration getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Duration productionTime) {
        this.productionTime = productionTime;
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
        OnDemandProduct that = (OnDemandProduct) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(productionTime, that.productionTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productionTime);
    }

    @Override
    public String toString() {
        return "OnDemandProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", productionTime=" + productionTime +
                '}';
    }
}
