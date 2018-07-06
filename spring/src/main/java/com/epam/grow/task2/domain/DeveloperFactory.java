package com.epam.grow.task2.domain;

import com.epam.grow.task1.domain.Developer;

public class DeveloperFactory {

    private Developer developer = new Developer();

    public Developer getDeveloper() {
        return developer;
    }

}
