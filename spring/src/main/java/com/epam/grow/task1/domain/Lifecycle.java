package com.epam.grow.task1.domain;

public class Lifecycle {

    private Project project;

    public Lifecycle() {
        System.out.println("default constructor");
    }

    public Lifecycle(Project project) {
        System.out.println("constructor with parameters");
        this.project = project;
    }

    public void init() {
        System.out.println("init method");
    }

    public void destroy() {
        System.out.println("destroy method ");
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        System.out.println("setter project");
        this.project = project;
    }

    @Override
    public String toString() {
        return "Lifecycle{" +
                "project=" + project +
                '}';
    }
}
