package com.epam.grow.task1;

import com.epam.grow.task1.domain.Developer;
import com.epam.grow.task1.domain.Lifecycle;
import com.epam.grow.task1.domain.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(final String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("task1/application-context.xml");
        part1(applicationContext);
        part2(applicationContext);
        part3(applicationContext);
        part4(applicationContext);
        part5(applicationContext);
        ((AbstractApplicationContext) applicationContext).close();
    }

    private static void part1(ApplicationContext applicationContext) {
        //1. Create bean A, use DI via setters, use property placeholder for values
        Developer developer = applicationContext.getBean("lead", Developer.class);
        System.out.println(developer);
    }

    private static void part2(ApplicationContext applicationContext) {
        //2. Create bean B, use DI via constructor (bean A as argument of constructor)
        Project project = applicationContext.getBean("project", Project.class);
        System.out.println(project);
    }

    private static void part3(ApplicationContext applicationContext) {
        //3. Create bean C with singleton scope and bean D with prototype scope. We need to add bean D as property of bean C. Pay attention that they have different scopes.
        // Consider Lookup Method Injection.
        Project firstProject = applicationContext.getBean("projectWithNotification", Project.class);
        Project secondProject = applicationContext.getBean("projectWithNotification", Project.class);
        System.out.println("first Project: Name - " + firstProject.getName() +
                ", Notification - " + firstProject.getProjectNotification().getNotification());
        System.out.println("second Project: Name - " + secondProject.getName() +
                ", Notification - " + secondProject.getProjectNotification().getNotification());
        System.out.println("This instance firstProject == secondProject: " + (firstProject == secondProject));
        System.out.println("This instance firstProjectNotification == secondProjectNotification: " +
                (firstProject.getProjectNotification() == secondProject.getProjectNotification()));
    }

    private static void part4(ApplicationContext applicationContext) {
        //4. Create bean E and replace logic of one of his method by Method Replacement
        Project project = applicationContext.getBean("project", Project.class);
        Project projectWithReplacer = applicationContext.getBean("projectWithReplacer", Project.class);

        System.out.print("This is result of replace method print of project: ");
        System.out.println(project);
        System.out.print("This is result of replace method print of projectWithReplacer: ");
        System.out.println(projectWithReplacer);
    }

    private static void part5(ApplicationContext applicationContext) {
        //5. Create bean F and log all possible steps from his lifecycle (lifecycle of Spring bean)
        applicationContext.getBean("lifecycle", Lifecycle.class);
    }
}
