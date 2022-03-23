package com.vaibhav.snippets.solid_desing_pricipals;

public class LiskovSubstitutionPrincipal {

    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(10,2);
        Rectangle r2 = new Rectangle(5,5);

        increaseHeight(r1);
        increaseHeight(r2);

        System.out.println(r1.calculateArea());//prints 22 correct
        System.out.println(r2.calculateArea());// prints 30 correct

        Rectangle rr = new Rectangle(10,2);
        Square ss = new Square(5,5);

        increaseHeight(rr);
        increaseHeight(ss);

        System.out.println(rr.calculateArea());// prints 22
        System.out.println(ss.calculateArea());// prints 36 , breaks liskov's principal as changing object to child changes the behaviour
    }

    private static void increaseHeight(Rectangle r) {
        r.setHeight(r.getHeight()+1);
    }
}

class Rectangle {
    private int height;
    private int breadth;

    public Rectangle(int height, int breadth) {
        this.height = height;
        this.breadth = breadth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public int calculateArea() {
        return this.breadth*this.height;
    }
}

class Square extends Rectangle {
    private int height;
    private int breadth;

    public Square(int height, int breadth) {
        super(height, breadth);
        this.height = height;
        this.breadth = breadth;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.breadth = height;
        this.height = height;
    }

    @Override
    public int getBreadth() {
        return breadth;

    }

    @Override
    public void setBreadth(int breadth) {
        this.breadth = breadth;
        this.height = height;
    }

    @Override
    public int calculateArea() {
        return this.breadth*this.height;
    }
}
