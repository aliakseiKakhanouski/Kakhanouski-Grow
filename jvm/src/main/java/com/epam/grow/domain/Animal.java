package com.epam.grow.domain;

import org.apache.log4j.Logger;

public interface Animal {

    Logger LOGGER = Logger.getLogger(Animal.class);

    void voice();
}
