package com.vaibhav.snippets.design_patterns.creational.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import static com.vaibhav.snippets.design_patterns.creational.builder.NyPizza.Size.SMALL;
import static com.vaibhav.snippets.design_patterns.creational.builder.Topping.HAM;
import static com.vaibhav.snippets.design_patterns.creational.builder.Topping.ONION;
import static com.vaibhav.snippets.design_patterns.creational.builder.Topping.SAUSAGE;

public class BuilderWithHirarchy {

    /*-
     the Builder pattern is a good choice when designing classes
    whose constructors or static factories would have more than a handful of
    parameters, especially if many of the parameters are optional or of identical type.
    Client code is much easier to read and write with builders than with telescoping
    constructors, and builders are much safer than JavaBeans
     */

    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
    }
}
enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
abstract class Pizza {

    final Set<Topping> toppings;
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }
        abstract Pizza build();
        // Subclasses must override this method to return "this"
        protected abstract T self();
    }
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }
}

class NyPizza extends Pizza {
    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;
    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;
        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }
        @Override public NyPizza build() {
            return new NyPizza(this);
        }
        @Override protected Builder self() { return this; }
    }
    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}

class Calzone extends Pizza {
    private final boolean sauceInside;
    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false; // Default
        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }
        @Override public Calzone build() {
            return new Calzone(this);
        }
        @Override protected Builder self() { return this; }
    }
    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}

