package com.epam.grow.annotation;

import com.epam.grow.model.PublicTransport;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class SetValueHandler {

    public static void setValue(Object obj) throws IllegalAccessException {
        List<Field> fieldList = Arrays.asList(PublicTransport.class.getDeclaredFields());
        for (Field field : fieldList) {
            SetValue setValue = field.getDeclaredAnnotation(SetValue.class);
            if (setValue != null) {
                if (field.isAccessible()){
                    field.setInt(obj, setValue.value());
                } else {
                    field.setAccessible(true);
                    field.setInt(obj, setValue.value());
                    field.setAccessible(false);
                }
            }
        }
    }
}
