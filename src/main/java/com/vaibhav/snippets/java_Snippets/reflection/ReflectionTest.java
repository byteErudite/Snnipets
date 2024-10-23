package com.vaibhav.snippets.java_Snippets.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionTest {



    public static void main(String[] args) {
        Test test = new Test();

        // using getFields : It can access all members of current class object including private
        Field[] fields = test.getClass().getDeclaredFields();
        List<String> fieldList = Arrays.stream(fields).map(f -> f.getName()).collect(Collectors.toList());
        System.out.println("The fields of class are : ");
        fieldList.forEach(System.out::println);


        // using getFields : It can access both child and parent members but not private
        Field[] fields2 = test.getClass().getFields();
        List<String> fieldList2 = Arrays.stream(fields2).map(f -> f.getName()).collect(Collectors.toList());
        System.out.println("The fields of class are : ");
        fieldList2.forEach(System.out::println);
    }

}

class Test extends SuperTest {
    private int field1;
    private int field2;
    public int field3;

}

class SuperTest {
    public int parentField1;
    private int parentField2;
}


