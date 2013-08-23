package com.algocrafts.algorithms;

import java.util.concurrent.TimeUnit;

public class Retry {

    private boolean on;
    private long count;
    private final long interval;
    private final TimeUnit unit;

    /**
     * Construct a retry instance.
     * @param count
     * @param interval
     * @param unit
     */
    public Retry(byte count, long interval, TimeUnit unit) {
        this.count = count;
        this.interval = interval;
        this.unit = unit;
    }

    public boolean done() {
        return count == 0 || !on;
    }

    public void on() {
        this.on = true;
    }

    public void off() {
        this.on = false;
    }

    public <T> T attempt(Attemptable<T> task) {
        T result = perform(task);

        while (!done()) {
            rest();
            result = perform(task);
        }
        return result;
    }

    private <T> T perform(Attemptable<T> task) {
        count--;
        try {
            return task.attempt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public long count() {
        return count;
    }

    private void rest() {
        try {
            unit.sleep(interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}