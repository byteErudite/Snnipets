package com.vaibhav.snippets.miscellaneous;

public class TestDiamondProblem {
}

interface A {
    default void defaultTest() {
        System.out.println("printing from interface A..........");
    }

    void test();
}
interface B {
    default void defaultTest() {
        System.out.println("printing from interface B..........");
    }
    void test();
}



class third implements A,B{
    A a;
    B b;

    @Override
    public void defaultTest() {

    }

    @Override
    public void test() {

    }
}
