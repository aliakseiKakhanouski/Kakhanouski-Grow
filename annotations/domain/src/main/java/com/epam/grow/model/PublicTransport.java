package com.epam.grow.model;

import com.epam.grow.annotation.SetValue;

public class PublicTransport {

    private double cost;

    @SetValue(5)
    private int count;

    public PublicTransport() {

    }

    public PublicTransport(double cost, int count) {
        this.cost = cost;
        this.count = count;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
