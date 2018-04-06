package com.epam.grow.domain;

public class Cat implements Animal {

    public Cat(){}

    @Override
    public void voice() {
        LOGGER.trace("meow");
        LOGGER.trace(getClass().getClassLoader());
    }
}
