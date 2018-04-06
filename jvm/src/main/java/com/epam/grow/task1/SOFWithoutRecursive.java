package com.epam.grow.task1;

import com.epam.grow.domain.Cat;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

import java.lang.reflect.Method;

public class SOFWithoutRecursive {
    // 5. java.lang.StackOverflowError. Do not use recursive methods. Don’t tune stack size.
    public static void main(String[] args)  throws Exception{
        CtClass ctclass = ClassPool.getDefault().get("com.epam.grow.domain.Cat");
        generateClass(ctclass);
        for (Method me : ctclass.toClass().getDeclaredMethods()) {
            if (me.getName().equals("meow5")) {
                System.out.println(me.getName());
            }
        }
        invoke();
    }
    /*Generating methods for a class com.epam.grow.domain.Cat
    * Methods look like this:
    * ...
    * public void meow1() {
    *
    *   int tmp0 = 0;
    *   int tmp1 = 1;
    *   ...
    *   int tmp8999 = 8999;
    *
    *   System.out.println("meow ok");
    *   meow0();
    * }
    * ...
    *
    * */
    public static void generateClass(CtClass ctclass) throws Exception{
        for (int j = 0; j < 50; j++) {
            StringBuilder builder = new StringBuilder("public void meow").append(j).append("()").append("{");
            for (int i = 0; i < 9000; i++) {
                builder.append("int tmp")
                        .append(i)
                        .append(" = ")
                        .append(i)
                        .append(";\n");
            }
            builder.append("System.out.println(\"meow ok\");");
            if (j > 0) {
                builder.append("meow")
                        .append((j - 1))
                        .append("();");
            }
            builder.append("}");

            CtMethod newMethod = CtNewMethod.make(builder.toString(), ctclass);
            ctclass.addMethod(newMethod);
        }
        ctclass.writeFile();
    }

    public static void invoke() throws Exception {
        Cat cat = new Cat();
        Method method = cat.getClass().getMethod("meow49");
        method.invoke(cat, new Object[]{});
    }
}
