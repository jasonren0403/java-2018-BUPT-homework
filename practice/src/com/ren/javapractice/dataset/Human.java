package com.ren.javapractice.dataset;

public class Human implements Measurable {
    private double measure;

    public Human(double ameasure) {
        measure = ameasure;
    }

    public double getMeasure() {
        return this.measure;
    }

    public String toString() {
        return "[" + getClass().getName() + "]" + "measure:" + getMeasure();
    }
}

