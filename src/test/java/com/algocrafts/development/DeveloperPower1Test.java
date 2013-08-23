package com.algocrafts.development;


import com.algocrafts.algorithms.Skill;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.util.EnumSet;
import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Developer.class, SVN.class, Build.class, Activities.class})
public class DeveloperPower1Test {

    private SVN svn;
    private Build build;
    private Activities activities;
    private EnumSet<Skill> skillSet;
    private List<File> files;

    @Test
    public void whenBuildIsGreen() {
        testWithMock(true, new Runnable() {
            @Override
            public void run() {
                svn = PowerMock.createMock(SVN.class);
                try {
                    svn.checkin(files);
                } catch (InvalidPasswordException e) {
                    e.printStackTrace();
                } catch (FileChangedException e) {
                    e.printStackTrace();
                }
                expectLastCall();
            }
        });
    }

    @Test
    public void whenBuildIsNotGreen() {
        testWithMock(false, new Runnable() {
            @Override
            public void run() {
                activities.drinkCoffee();
                EasyMock.expectLastCall();
            }
        });
    }

    private void testWithMock(boolean b, Runnable variant) {
        activities = PowerMock.createMock(Activities.class);
        activities.standupMeeting();
        EasyMock.expectLastCall();
        expect(activities.tdd()).andReturn(files).times(2);

        build = PowerMock.createMock(Build.class);
        expect(build.isGreen()).andReturn(b);

        variant.run();

        activities.lunch();
        expectLastCall();

        replayAll();

        new Developer(null, skillSet, svn, build, activities).work();
        verifyAll();
    }

}
