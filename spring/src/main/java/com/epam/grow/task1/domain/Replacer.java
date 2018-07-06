package com.epam.grow.task1.domain;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class Replacer implements MethodReplacer{

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        return "Project{ projectWithReplacer }";
    }
}
