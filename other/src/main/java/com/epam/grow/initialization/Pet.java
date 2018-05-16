package com.epam.grow.initialization;

public class Pet {

    private String name;
    private final String badName;

    static {
        System.out.println("Static block in Pet");
    }

    {
        System.out.println("Block in Pet");
        badName = "Bad Pet";
    }

    public Pet() {
        System.out.println("Pet constructor without Name");
    }

    public Pet(String name) {
        System.out.println("Pet constructor with Name" + name);
        this.name = name;
    }
}
