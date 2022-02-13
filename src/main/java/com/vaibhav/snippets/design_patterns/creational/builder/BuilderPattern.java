package com.vaibhav.snippets.design_patterns.creational.builder;

import java.util.StringJoiner;

public class BuilderPattern {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        NutritionFacts limca = new NutritionFacts.Builder(240, 8)
                .calories(50).build();
        System.out.println("cocaCola : "+cocaCola);
        System.out.println("limca : "+limca);
    }
}
/*
     Generally constructors are used for instantiating an object at time of creation , but if the number of parameters
     are large and similar in nature then this technique becomes prone to errors as if the user of the class swaps the
     parameters by mistake that could lead to wrong behaviour.

     Also in a class many a times lot of fields are optional so it really does not makes sense to put in all the
     variables in constructor as the user will have to provide a basic value or any value even if he is not
     planning to populate that field. So , we can create many constructors with different parameters to provide
     various required combinations of the fields but as the number of fields grow this process becomes inefficient.

     We can use java beans pattern to solve this issue and provide setter methods to all the variables and in constructor
     instantiate class with 0 fields. but in that case while creating an object with certain field values, we have to
     call setter methods multiple times on the object and the object creation is no  longer a single atomic operation.
     This could lead to various syncronization errors where we might face inconsistent state object .

     So , to solve all this we have builder patter , an example is shown below where the class Nutrition has two
     mandatory and 4 optional fields
 */

class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public Builder calories(int val)
        { calories = val; return this; }
        public Builder fat(int val)
        { fat = val; return this; }
        public Builder sodium(int val)
        { sodium = val; return this; }
        public Builder carbohydrate(int val)
        { carbohydrate = val; return this; }
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }
    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NutritionFacts.class.getSimpleName() + "[", "]")
                .add("servingSize=" + servingSize)
                .add("servings=" + servings)
                .add("calories=" + calories)
                .add("fat=" + fat)
                .add("sodium=" + sodium)
                .add("carbohydrate=" + carbohydrate)
                .toString();
    }
}
