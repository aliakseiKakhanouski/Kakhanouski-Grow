package com.epam.grow.task1.domain;

public class ProjectNotification {

    private String notification;

    public ProjectNotification(String notification) {
        this.notification = notification;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    @Override
    public String toString() {
        return "ProjectNotification{" +
                "notification='" + notification + '\'' +
                '}';
    }
}
