package com.algocrafts.development;

import com.algocrafts.algorithms.Skill;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class Developer {

    private static final Logger log = Logger.getLogger(Developer.class);

    private final String name;

    private final EnumSet<Skill> skillSet;

    private final VersionControl versionControl;
    private final Build build;
    private final Activities activities;

    public Developer(String name, EnumSet<Skill> skillSet, VersionControl versionControl, Build build, Activities activities) {
        this.name = name;
        this.skillSet = skillSet;
        this.versionControl = versionControl;
        this.build = build;
        this.activities = activities;
    }

    public void work() {

        activities.standupMeeting();
        List<File> files = activities.tdd();
        if (build.isGreen()) {
            try {
                if (log.isInfoEnabled()) {
                    log.info("Checking in files, " + files);
                }
                versionControl.checkin(files);
            } catch (InvalidPasswordException e) {
                log.error("Your password has expired", e);
            } catch (FileChangedException e) {
                log.error("The file has been changed by other people, please update first.", e);
            }
        } else {
            activities.drinkCoffee();
        }
        activities.lunch();
        activities.tdd();
    }

    public boolean hasSkills(Skill ... skills) {
       return skillSet.containsAll(Arrays.asList(skills));
    }

    public String getName() {
        return name;
    }
}
