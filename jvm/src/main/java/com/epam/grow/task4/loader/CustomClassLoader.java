package com.epam.grow.task4.loader;

import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;

public class CustomClassLoader extends ClassLoader {

    private static Logger LOGGER = Logger.getLogger(CustomClassLoader.class);

    @Override
    public Class<?> findClass(String name) {
        DataInputStream dis = new DataInputStream(getResourceAsStream(name.replace(".", File.separator) + ".class"));
        byte[] data = new byte[0];
        try {
            data = new byte[dis.available()];
            dis.readFully(data);
        } catch (IOException e) {
            LOGGER.trace(e);
        }
        return defineClass(name, data, 0, data.length);
    }
}
