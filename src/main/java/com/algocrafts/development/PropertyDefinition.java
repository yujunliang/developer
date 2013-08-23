package com.algocrafts.development;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PropertyDefinition {

    public byte getCount() {
        return (byte) 3;
    }

    public long getInterval() {
        return 10L;
    }

    public TimeUnit getTimeUnit() {
        return SECONDS;
    }
}
