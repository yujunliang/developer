package com.algocrafts.development;

import com.algocrafts.algorithms.HasSkills;
import com.algocrafts.algorithms.Skill;
import com.google.common.base.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Lists.newArrayList;

public class Recruitment {

    private List<Developer> candidates;

    public Recruitment(List<Developer> candidates) {

        this.candidates = candidates;
    }

    public List<Developer> hire(Skill... skills) {
        List<Developer> hired = new ArrayList<Developer>();
        for (Developer developer : candidates) {
            if (developer.hasSkills(skills)) {
                hired.add(developer);
            }
        }
        return hired;
    }

    public List<Developer> hire2(final Skill... skills) {
        return newArrayList(filter(candidates, new Predicate<Developer>() {
            @Override
            public boolean apply(Developer developer) {
                return developer.hasSkills(skills);
            }
        }));
    }

    public List<Developer> hire3(final Skill... skills) {
        return newArrayList(filter(candidates, new HasSkills(skills)));
    }

    public Stream<Developer> hire4(final Skill... skills) {
        return candidates.stream().filter(new HasSkills(skills));
    }



}
