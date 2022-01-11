package com.vaibhav.snippets.multithreading.future_api;


public class FactModel {
    private String fact;
    private int length;


    public FactModel(String fact, int length) {
        this.fact = fact;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public FactModel() {
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public FactModel(String fact) {
        this.fact = fact;
    }
}
