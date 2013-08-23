package com.algocrafts.development;

import com.algocrafts.algorithms.HasSkills;
import com.algocrafts.algorithms.Skill;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.powermock.api.easymock.PowerMock.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Developer.class, Recruitment.class, Predicate.class, Collections2.class,Lists.class })
public class RecruitmentPowerTest {

    @Test
    public void testHire3() throws Exception {
        List<Developer> candidates = createMock(List.class);

        Skill[] skills = new Skill[0];
        HasSkills hasSkills = createMock(HasSkills.class);
        expectNew(HasSkills.class, skills).andReturn(hasSkills);

        Collection<Developer> filtered = createMock(Collection.class);
        mockStatic(Collections2.class);
        expect(Collections2.filter(candidates, hasSkills)).andReturn(filtered);

        mockStatic(Lists.class);
        ArrayList<Developer> list = createMock(ArrayList.class);
        expect(Lists.newArrayList(filtered)).andReturn(list);

        replayAll();

        List<Developer> hired = new Recruitment(candidates).hire3(skills);
        verifyAll();

        assertEquals(list, hired);

    }
}
