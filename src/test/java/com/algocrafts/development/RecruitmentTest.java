package com.algocrafts.development;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.algocrafts.algorithms.Skill.*;
import static org.junit.Assert.assertEquals;

public class RecruitmentTest {


    private Recruitment recruitment;

    @Before
    public void before() {
        List<Developer> candidates = new ArrayList<Developer>();
        candidates.add(new Developer("Jack", EnumSet.of(JAVA, C), null, null, null));
        candidates.add(new Developer("Bob", EnumSet.of(COBOL, C, C_SHARP), null, null, null));
        candidates.add(new Developer("Sanjay", EnumSet.of(JAVA, CPP), null, null, null));
        candidates.add(new Developer("Weidong", EnumSet.of(JAVA, C_SHARP), null, null, null));
        candidates.add(new Developer("Wendy", EnumSet.of(JAVA, C_SHARP), null, null, null));

        recruitment = new Recruitment(candidates);

    }

    @Test
    public void testHire() throws Exception {
        List<Developer> hired = recruitment.hire(JAVA, C_SHARP);
        assertEquals(2, hired.size());
        assertEquals("Weidong", hired.get(0).getName());
        assertEquals("Wendy", hired.get(1).getName());
    }

    @Test
    public void testHire2() throws Exception {
        List<Developer> hired = recruitment.hire2(JAVA, C_SHARP);
        assertEquals(2, hired.size());
        assertEquals("Weidong", hired.get(0).getName());
        assertEquals("Wendy", hired.get(1).getName());
    }

    @Test
    public void testHire3() throws Exception {
        List<Developer> hired = recruitment.hire3(JAVA, C_SHARP);
        assertEquals(2, hired.size());
        assertEquals("Weidong", hired.get(0).getName());
        assertEquals("Wendy", hired.get(1).getName());
    }

    @Test
    public void testHire4() throws Exception {
        Stream<Developer> hired = recruitment.hire4(JAVA, C_SHARP);
  //      assertEquals(2, hired.count());
        List<Developer> list = hired.collect(Collectors.<Developer>toList());
        assertEquals("Weidong", list.get(0).getName());
        assertEquals("Wendy", list.get(1).getName());
    }
}
