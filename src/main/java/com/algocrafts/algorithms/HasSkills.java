package com.algocrafts.algorithms;

import com.algocrafts.development.Developer;
import com.google.common.base.Predicate;

public class HasSkills implements Predicate<Developer>, java.util.function.Predicate<Developer> {


    private Skill[] skills;

    public HasSkills(Skill... skills) {
        this.skills = skills;
    }

    @Override
    public boolean apply(Developer developer) {
        return developer.hasSkills(skills);
    }

    @Override
    public boolean test(Developer developer) {
        return developer.hasSkills(skills);
    }
}