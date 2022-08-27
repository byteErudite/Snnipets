package com.vaibhav.snippets.codingProblems;

import java.util.*;

public class RomanToDecimal {
    /**
     * Given an integer, convert it to a roman numeral.
     * @return
     */

    public static void main(String[] args) {
        System.out.println(intToRoman(45));
        System.out.println(intToRoman(994));
        System.out.println(intToRoman(1935));
    }
    public static String intToRoman(int num) {
        Map<Integer,String> romanToDecimal = getNumberToRomanMap();
        List<Integer> denominations = Arrays.asList(1,4,5,9,10,40,50,90,100,400,500,900,1000);
        int index = denominations.size()-1;
        StringBuffer result = new StringBuffer();
        while(num > 0 && index >= 0) {
            int factor = num / denominations.get(index);
            num = num - factor*denominations.get(index);
            for(int i = 0 ; i < factor ; i++) {
                result.append(romanToDecimal.get(denominations.get(index)));
            }
            index--;
        }
        return result.toString();

    }



    private static Map<Integer,String> getNumberToRomanMap() {
        Map<Integer,String> romanMapping = new HashMap<>();
        romanMapping.put(1, "I");
        romanMapping.put(4,"IV");
        romanMapping.put(5, "V");
        romanMapping.put(9, "IX");
        romanMapping.put(10, "X");
        romanMapping.put(40, "XL");
        romanMapping.put(50, "L");
        romanMapping.put(90, "XC");
        romanMapping.put(100, "C");
        romanMapping.put(400, "CD");
        romanMapping.put(500, "D");
        romanMapping.put(900, "CM");
        romanMapping.put(1000, "M");
        return romanMapping;
    }
}
