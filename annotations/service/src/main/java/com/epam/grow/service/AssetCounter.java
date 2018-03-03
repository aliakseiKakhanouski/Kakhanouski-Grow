package com.epam.grow.service;

import com.epam.grow.model.*;

public class AssetCounter {

    public double calculateCost(PublicTransport transport) {
        return transport.getCount() * transport.getCost();
    }
}
