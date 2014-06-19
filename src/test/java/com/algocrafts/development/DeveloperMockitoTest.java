package com.algocrafts.development;

import com.algocrafts.algorithms.Skill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.EnumSet;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DeveloperMockitoTest {

    @Mock private VersionControl svn;
    @Mock private Build build;
    @Mock private Activities activities;
    @Mock private EnumSet<Skill> skillSet;
    private String name = "Jack";
    @Mock private List files;

    @Test
    public void whenBuildIsGreen() throws FileChangedException, InvalidPasswordException {

        when(build.isGreen()).thenReturn(true);
        when(activities.tdd()).thenReturn(files) ;

        new Developer(name, skillSet, svn, build, activities).work();
        verify(activities).standupMeeting();

        verify(svn).checkin(files);
        verify(activities, never()).drinkCoffee();
        verify(activities).lunch();
    }

    @Test
    public void whenBuildIsNotGreen() throws FileChangedException, InvalidPasswordException {

        when(build.isGreen()).thenReturn(false);
        when(activities.tdd()).thenReturn(files) ;

        new Developer(name, skillSet, svn, build, activities).work();
        verify(activities).standupMeeting();
        verify(svn, never()).checkin(files);
        verify(activities).drinkCoffee();
        verify(activities).lunch();
    }
}
