package com.epam.grow.task2.domain;

import com.epam.grow.task1.domain.Developer;

public class Description {

    public static final String JUNIOR = "junior";
    public static final String LEAD = "lead";

    private Developer developer;
    private int years;
    private String title;

    public Description() {

    }

    public Description(Developer developer, int years, String title) {
        this.developer = developer;
        this.years = years;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Description{" +
                "developer=" + developer +
                ", years=" + years +
                ", title='" + title + '\'' +
                '}';
    }
}
