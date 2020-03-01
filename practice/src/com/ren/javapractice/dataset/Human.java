package com.ren.javapractice.dataset;

public class Human implements Measurable {
    private double measure;
    private String type;

    public Human(String atype, double ameasure) {
        type = atype;
        measure = ameasure;
    }

    public String getType() {
        return type;
    }

    public double getMeasure() {
        return this.measure;
    }
}

