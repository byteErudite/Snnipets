package com.vaibhav.snippets.design_patterns.behavioural;

import java.util.List;
import java.util.ArrayList;


class ObserverPattern {

}

class Product implements Observable{
    String name;
    int price;
    boolean isAvailable;
    List<Observer> observers;

    Product(String name, int price, boolean isAvailable) {
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
        this.observers = new ArrayList<Observer>();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }
    public void notifyObservers() {
        observers.clear();
    }

    void setIsAvailable(boolean isAvailable)  {
        this.isAvailable = isAvailable;
        if (isAvailable) {
            observers.forEach(obs -> obs.update(this));
        }
    }
}
interface Observable {
    void addObserver(Observer o);
    void notifyObservers();
}

interface Observer {
    void update(Observable o);
}

class ProductObserver implements Observer {
    public void update(Observable o) {
        Product p = (Product) o;
        System.out.println("Product " + p.name + " is now " + (p.isAvailable ? "available" : "not available"));
    }
}