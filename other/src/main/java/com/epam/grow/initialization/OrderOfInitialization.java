package com.epam.grow.initialization;

public class OrderOfInitialization {
    /*
        Answer:
        1. Static block in Pet
        2. Static block 1 in Cat
        3. Static block 2 in Cat
        4. Block in Pet
        5. Pet constructor without Name
        6. Block in Cat
        7. Cat conctructor with Name: Rizhick
    */
    public static void main(String[] args) {
        Cat cat = new Cat("Rizhick");
    }
}
