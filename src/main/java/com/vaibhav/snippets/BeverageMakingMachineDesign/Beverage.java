package com.vaibhav.snippets.BeverageMakingMachineDesign;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Beverage {
    String beverageName;
    String beverageType;
    Map<Ingridient,Integer> ingridients;
    BeverageTemperature beverageTemperature;
    Timestamp createdAt;

    public Beverage() {
        ingridients = new HashMap<>();
        createdAt = Timestamp.from(Instant.now());
    }

    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    public String getBeverageType() {
        return beverageType;
    }

    public void setBeverageType(String beverageType) {
        this.beverageType = beverageType;
    }

    public Map<Ingridient, Integer> getIngridients() {
        return ingridients;
    }

    public void setIngridients(Map<Ingridient, Integer> ingridients) {
        this.ingridients = ingridients;
    }

    public BeverageTemperature getBeverageTemperature() {
        return beverageTemperature;
    }

    public void setBeverageTemperature(BeverageTemperature beverageTemperature) {
        this.beverageTemperature = beverageTemperature;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getInfo() {
        return new StringJoiner(", ", Beverage.class.getSimpleName() + "[", "]")
                .add("beverageName='" + beverageName + "'")
                .add("beverageType='" + beverageType + "'")
                .add("ingridients=" + ingridients.keySet().stream().map(String::valueOf).collect(Collectors.toList()))
                .add("beverageTemperature=" + beverageTemperature)
                .add("createdAt=" + createdAt)
                .toString();
    }
}
