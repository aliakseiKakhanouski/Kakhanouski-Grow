package com.epam.grow.task2;

import com.epam.grow.task1.domain.Developer;
import com.epam.grow.task1.domain.Lifecycle;
import com.epam.grow.task2.domain.Description;
import com.epam.grow.task2.domain.DescriptionServiceFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(final String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("task2/application-context-part-one.xml");
        part2(applicationContext);
        part3(applicationContext);
        part4(applicationContext);
        part5(applicationContext);
        part6(applicationContext);
        part7(applicationContext);
        part8(applicationContext);
        ((AbstractApplicationContext) applicationContext).close();
    }

    private static void part2(ApplicationContext applicationContext) {
        System.out.println("2. Use different bean scope (singleton, prototype)");
        Developer firstSingleton = applicationContext.getBean("singletonDeveloper", Developer.class);
        Developer secondSingleton = applicationContext.getBean("singletonDeveloper", Developer.class);
        System.out.println("firstSingleton == secondSingleton is: " + (firstSingleton == secondSingleton));

        Developer firstPrototype = applicationContext.getBean("prototypeDeveloper", Developer.class);
        Developer secondPrototype = applicationContext.getBean("prototypeDeveloper", Developer.class);
        System.out.println("firstPrototype == secondPrototype is: " + (firstPrototype == secondPrototype));
    }

    private static void part3(ApplicationContext applicationContext) {
        System.out.println("3. Use factory-method (singleton) and factory-bean (service locator), implement FactoryBean interface");
        Developer developer = applicationContext.getBean("firstDeveloper", Developer.class);
        System.out.println("Developer created using factory method: " + developer);

        DescriptionServiceFactory descriptionServiceFactory = applicationContext.getBean("descriptionServiceFactory", DescriptionServiceFactory.class);
        Description description = descriptionServiceFactory.getDescription();
        System.out.println("Description create using factory-bean(service locator): " + description);

        developer = applicationContext.getBean("developerFactoryBean", Developer.class);
        System.out.println("Developer create using FactoryBean interface: " + developer);
    }

    private static void part4(ApplicationContext applicationContext) {
        System.out.println("4. Pass bean references, string constants and primitive types as constructor parameters via xml configuration");
        Description description = applicationContext.getBean("description", Description.class);
        System.out.println("This is Description: " + description.toString());
    }

    private static void part5(ApplicationContext applicationContext) {
        System.out.println("5. Use setter approach for passing bean parameters");
        Developer developer = applicationContext.getBean("developer", Developer.class);
        System.out.println("This developer use setter approach for passing bean parameters: " + developer);
    }

    private static void part6(ApplicationContext applicationContext) {
        System.out.println("6. Divide complex xml configs into a few simple");
        System.out.println("Xml configs divide to application-context-part-one.xml and application-context-part-two.xml");
    }

    private static void part7(ApplicationContext applicationContext) {
        System.out.println("7. Implement bean which sets property username=Awesome in spring context");
        Developer awesomeDeveloper = applicationContext.getBean("awesomeDeveloper", Developer.class);
        System.out.println("This is awesomeDeveloper: " + awesomeDeveloper);
    }

    private static void part8(ApplicationContext applicationContext) {
        System.out.println("8. Implement bean that sends message to log at initialization and destroy phases");
        System.out.println("Lifecycle of the lifeCycleBean beans: ");
        Lifecycle lifeCycleBean = applicationContext.getBean("lifeCycleBean", Lifecycle.class);
        System.out.println("This is lifeCycleBean: " + lifeCycleBean);
    }
}
