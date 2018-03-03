package com.epam.grow.service;

import com.epam.grow.annotation.SetValueHandler;
import com.epam.grow.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AssetCounterTest {

    private AssetCounter assetCounter = new AssetCounter();
    private PublicTransport publicTransport;

    @Before
    public void before() throws IllegalAccessException {
        publicTransport = new PublicTransport(100.0, 6);
        SetValueHandler.setValue(publicTransport);
    }

    @Test
    public void calculateCostTest() {
        double actual = assetCounter.calculateCost(publicTransport);
        double expected = 500;
        Assert.assertEquals(expected, actual, 0);
    }
}
