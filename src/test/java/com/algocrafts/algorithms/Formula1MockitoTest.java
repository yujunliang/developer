package com.algocrafts.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Formula1MockitoTest {

    @Mock private BigDecimal a;
    @Mock private BigDecimal b;
    @Mock private BigDecimal c;
    @Mock private BigDecimal temp1;
    @Mock private BigDecimal temp2;
    @Mock private BigDecimal temp3;

    @Test
    public void testOperate() throws Exception {
        when(a.add(b)).thenReturn(temp1);
        when(c.multiply(b)).thenReturn(temp2);
        when(temp2.divide(a)).thenReturn(temp2);
        when(temp1.subtract(temp2)).thenReturn(temp3);
        new Formula1(a, b, c).operate();
        verify(a).add(b);
        verify(c).multiply(b);
        verify(temp1).subtract(temp2);
    }
}
