package com.algocrafts.development;


import com.algocrafts.algorithms.Skill;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.EnumSet;
import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Developer.class, VersionControl.class, Build.class, Activities.class})
public class DeveloperPowerTest {

    private VersionControl svn;
    private Build build;
    private Activities activities;

    @Test
    public void whenBuildIsGreen() throws FileChangedException, InvalidPasswordException {
        activities = createMock(Activities.class);
        activities.standupMeeting();
        expectLastCall();
        List files = createMock(List.class);
        expect(activities.tdd()).andReturn(files).times(2);

        build = createMock(Build.class);
        expect(build.isGreen()).andReturn(true);

        svn = createMock(VersionControl.class);
        svn.checkin(files);
        expectLastCall();

        activities.lunch();
        expectLastCall();

        replayAll();

        new Developer(null, null, svn, build, activities).work();
        verifyAll();
    }

    @Test
    public void whenBuildIsNotGreen() {

        activities = createMock(Activities.class);
        activities.standupMeeting();
        expectLastCall();
        List files = createMock(List.class);
        expect(activities.tdd()).andReturn(files).times(2);


        build = createMock(Build.class);
        expect(build.isGreen()).andReturn(false);

        activities.drinkCoffee();
        EasyMock.expectLastCall();

        activities.lunch();
        expectLastCall();

        replayAll();

        new Developer(null, null, svn, build, activities).work();
        verifyAll();
    }

}
