package com.epam.grow.domain;

public class Dog implements Animal {

    public Dog() {}

    @Override
    public void voice() {
        LOGGER.trace("awu");
        LOGGER.trace(getClass().getClassLoader());
    }
}
