package com.algocrafts.algorithms;

import java.math.BigDecimal;

public class Formula1 {

    private final BigDecimal a;
    private final BigDecimal b;
    private final BigDecimal c;

    public Formula1(BigDecimal a, BigDecimal b, BigDecimal c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     *
     * (a + b) - (c * b ) / a
     * @return
     */
    public BigDecimal operate() {
        BigDecimal temp1 = a.add(b);
        BigDecimal temp2 = c.multiply(b);
        temp2 = temp2.divide(a);
        return temp1.subtract(temp2);
    }
}
