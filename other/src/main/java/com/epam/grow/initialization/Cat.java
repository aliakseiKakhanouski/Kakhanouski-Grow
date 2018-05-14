package com.epam.grow.initialization;

public class Cat extends Pet{

    private String name;

    static {
        System.out.println("Static block 1 in Cat");
    }

    static {
        System.out.println("Static block 2 in Cat");
    }

    {
        System.out.println("Block in Cat");
    }

    public Cat() {
        System.out.println("Cat empty constructor");
    }

    public Cat(String name) {
        System.out.println("Cat conctructor with Name: " + name);
        this.name = name;
    }
}
