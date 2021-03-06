package com.vaibhav.snippets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Demo1 {
    public static void main(String[] args) {

//       List<Integer> arr1 = Arrays.asList(2, 1, 8, 9, 5);
//       List<Integer> arr2 = Arrays.asList(6, 7, 6, 7, 4, 1, 3, 0, 1, 8);
//        System.out.println(addArrays(arr1, arr2));
//
//
//        List<Order> values = new ArrayList();
//        List<Integer> list = Arrays.asList(10, 20, 50, 100, 130, 150, 200, 250, 500);
//        IntSummaryStatistics summaryStats = list.stream()
//                .mapToInt((a) -> a)
//                .summaryStatistics();
        Comparator<Order> byPrice = Comparator.comparing(Order::getPrice);
        SortedSet<Order> set = new TreeSet<>(byPrice);
        set.add(new Order("Book", 50));
        set.add(new Order("Pen", 10));
        set.add(new Order("Copy", 20));
        for(Order o : set) {
            System.out.println("Product : "+o.getItem()+" price : "+o.getPrice());
        }

    }




    public static ArrayList<Integer> addArrays(List<Integer> A, List<Integer> B) {
        int carr =0;
        int i = A.size()-1;
        int j = B.size()-1;
        ArrayList<Integer> answer = new ArrayList<>();
        do {
            int num = A.get(i) + B.get(j) + carr;
            carr = num/ 10;
            int val = num %10;
            answer.add(val);
            i--;
            j--;
        }while(i >= 0 && j >= 0) ;
        while(i >=0) {
            answer.add(A.get(i--));
        }
        while(j >= 0) {
            answer.add(B.get(j--));
        }
        Collections.reverse(answer);
        return answer;
    }

}

class Order  {
    private String item;
    private int price;

    public Order(String item, int price) {
        this.item = item;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    @Override
//    public int compareTo(Order o) {
//        return this.price > o.price ? 1 : -1;
//    }
}
