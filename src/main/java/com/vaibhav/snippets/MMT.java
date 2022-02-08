package com.vaibhav.snippets;

import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

public class MMT {
    //coffe vending machine
    // tea & coffee
    // Tea -> masal Tea , Green Tea
    // coffee -> Capp , latte

    public static void main(String[] args) {
        int[] arr1 = {1,2};
        int[] arr2 = {3,4};
        System.out.println(findMedianOfSortedArrays(arr1, arr2));
    }

    private static double findMedianOfSortedArrays(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        int resultingArrLength = length1 + length2;
        int targetLength = resultingArrLength % 2 == 0 ? resultingArrLength /2 + 1 : resultingArrLength/2;
        int[] resultArray = new int[resultingArrLength+1];
        int i = 0 ; int j =0;
        int count = 0;

        //int currentValue = 0;
        while (i < length1 & j < length2) {

            if (arr1[i] <= arr2[j]) {
                resultArray[count]  = arr1[i];
                //currentValue = arr1[i];
                i++;
            } else {
                resultArray[count]  = arr2[j];
                //currentValue = arr2[j];
                j++;
            }
            count++;
            if(count == targetLength )  {
                if(resultingArrLength % 2 == 0) {
                    return (double)((resultArray[count] + resultArray[count -1])/2);
                } else {
                    return resultArray[count];
                }
            }
        }

        while(i < length1) {
            resultArray[count] = arr1[i];
            if(count == targetLength) {
                if(resultingArrLength % 2 == 0) {
                    return (double)((resultArray[count-1] + resultArray[count -2])/2);
                } else {
                    return resultArray[count];
                }
            }
            count++;
            i++;
        }
        while (j < length2) {
            resultArray[count] = arr2[j];
            if(count == targetLength) {
                if(resultingArrLength % 2 == 0) {
                    return (double)((resultArray[count-1] + resultArray[count -2])/2);
                } else {
                    return resultArray[count];
                }
            }
            count++;
            j++;
        }
        return 0;
    }
}

class Receipe {
    private List<String> ingridients;
    private String name;
    private String size;
    private int timeToCook;


    public List<String> getIngridients() {
        return ingridients;
    }

    public Receipe setIngridients(List<String> ingridients) {
        this.ingridients = ingridients;
        return this;
    }

    public String getName() {
        return name;
    }

    public Receipe setName(String name) {
        this.name = name;
        return this;
    }

    public String getSize() {
        return size;
    }

    public Receipe setSize(String size) {
        this.size = size;
        return this;
    }

    public int getTimeToCook() {
        return timeToCook;
    }

    public Receipe setTimeToCook(int timeToCook) {
        this.timeToCook = timeToCook;
        return this;
    }
}

enum BeverageType {
    MASALA_TEA, GREEN_TEA, CAPP_COFFEE, LATTE_COFFEE
}

class VendingMachine {
    public Beverage createBeverage(BeverageType beverageType) {
//        switch (beverageType) {
//            case GREEN_TEA: return new Tea(BeverageType.GREEN_TEA);
//            break;
//            case MASALA_TEA:_TEA: return new Tea(BeverageType.GREEN_TEA);
//            break;
//            case LATTE_COFFEE: return new Tea(BeverageType.GREEN_TEA);
//            break;
//            case CAPP_COFFEE: return new Tea(BeverageType.GREEN_TEA);
//            break;
//        }
        return null;
    }
}



abstract class Beverage {
    private String BeverageType;
    private Date madeAt;
    abstract void getBeverageInfo();

    @Override
    public String toString() {
        return new StringJoiner(", ", Beverage.class.getSimpleName() + "[", "]")
                .add("BeverageType='" + BeverageType + "'")
                .add("madeAt=" + madeAt)
                .toString();
    }
}

class Tea extends Beverage{
    private BeverageType teaType;

    public Tea(BeverageType teaType) {
        this.teaType = teaType;
    }

    @Override
    void getBeverageInfo() {
        System.out.println("The beverage info is as follows: ");
        System.out.println("tea type :" +teaType);
        System.out.println(super.toString());
    }
}

class Coffee extends Beverage {

    private BeverageType coffeeType;

    public Coffee(BeverageType coffeeType) {
        this.coffeeType = coffeeType;
    }

    @Override
    void getBeverageInfo() {
        System.out.println("The beverage info is as follows: ");
        System.out.println("tea type :" +coffeeType);
        System.out.println(super.toString());
    }
}


