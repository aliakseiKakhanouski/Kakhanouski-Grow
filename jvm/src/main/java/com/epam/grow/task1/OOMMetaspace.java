package com.epam.grow.task1;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;

import java.util.ArrayList;
import java.util.List;

public class OOMMetaspace {
    // 3. java.lang.OutOfMemoryError: Metaspace. Load classes continuously and make them stay in memory.
    // -XX:MaxMetaspaceSize=10M
    public static void main(String[] args) throws CannotCompileException {
        outOfMemory();
    }

    private static void outOfMemory() throws CannotCompileException{
        List<Class> classes = new ArrayList<>();
        for (int i=0; i<Integer.MAX_VALUE; i++) {
            ClassPool pool = ClassPool.getDefault();
            CtClass cc = pool.makeClass("Task");
            cc.replaceClassName("Task", "name"+i);
            classes.add(cc.toClass());
        }
    }
}
