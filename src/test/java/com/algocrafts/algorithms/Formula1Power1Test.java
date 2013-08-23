package com.algocrafts.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Formula1.class, BigDecimal.class})
public class Formula1Power1Test {

    private BigDecimal a = createMock(BigDecimal.class);
    private BigDecimal b = createMock(BigDecimal.class);
    private BigDecimal c = createMock(BigDecimal.class);
    private BigDecimal temp1 = createMock(BigDecimal.class);
    private BigDecimal temp2 = createMock(BigDecimal.class);

    @Test
    public void testOperate() throws Exception {
        expect(a.add(b)).andReturn(temp1);
        expect(c.multiply(b)).andReturn(temp2);
        expect(temp2.divide(a)).andReturn(temp2);
        expect(temp1.subtract(temp2)).andReturn(ONE);
        replayAll();
        new Formula1(a, b, c).operate();
        verifyAll();
    }
}
