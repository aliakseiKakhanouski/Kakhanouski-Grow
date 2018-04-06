package com.epam.grow.task4;

import com.epam.grow.task4.loader.CustomClassLoader;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// 1. Create a new abstract class (or interface) Animal with methods: Play, Voice.
// 2. Inherit Cat and Dog from the Animal class.
// 3. Compile the classes.
// 4. Create your own ClassLoader by extension of the standard ClassLoader.
// 5. Load the classes Cat and Dog into an array or collection Animals by your own class loader and run the methods &quot;Play&quot;, &quot;Voice&quot;.
// 6. Output data to console by log4j library (logger).
public class CCL {

    private static Logger LOGGER = Logger.getLogger(CCL.class);

    public static void main(String[] args) throws NoSuchMethodException {
        loadClass();
    }

    public static void loadClass() throws NoSuchMethodException {

        CustomClassLoader classLoader = new CustomClassLoader();
        Class animalClass = classLoader.findClass("com.epam.grow.domain.Animal");

        Method methodVoice = animalClass.getDeclaredMethod("voice");

        List<Object> animals = new ArrayList<>();
        try {
            animals.add(classLoader.findClass("com.epam.grow.domain.Cat").newInstance());
            animals.add(classLoader.findClass("com.epam.grow.domain.Dog").newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.trace(e);
        }

        invoke(methodVoice, animals);
    }

    public static void invoke(Method method ,List<Object> animals) {
        animals.forEach(animal -> {
            try {
                method.invoke(animal);
            } catch (IllegalAccessException | InvocationTargetException e) {
                LOGGER.trace(e);
            }
        });
    }

}
