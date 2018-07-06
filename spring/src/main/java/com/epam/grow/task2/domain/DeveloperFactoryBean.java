package com.epam.grow.task2.domain;

import com.epam.grow.task1.domain.Developer;
import org.springframework.beans.factory.FactoryBean;

public class DeveloperFactoryBean implements FactoryBean<Developer> {

    private String name;
    private int level;
    private String skill;

    public DeveloperFactoryBean(String name, int level, String skill) {
        this.name = name;
        this.level = level;
        this.skill = skill;
    }

    @Override
    public Developer getObject() throws Exception {
        Developer developer = new Developer();
        developer.setName(name);
        developer.setLevel(level);
        developer.setSkill(skill);
        return developer;
    }

    @Override
    public Class<?> getObjectType() {
        return Developer.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
