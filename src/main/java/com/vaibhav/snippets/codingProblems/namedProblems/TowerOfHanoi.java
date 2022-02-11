package com.vaibhav.snippets.codingProblems.namedProblems;

public class TowerOfHanoi {
    public static void main(String[] args) {
        towerOfHanoi("Source", "Extra", "Destination", 5);
    }

    private static void towerOfHanoi(String s, String d, String e, int len) {
        if (len ==0 ) {
            return;
        }
        towerOfHanoi(s,e,d,len-1);
        System.out.println("Moving "+len+" from "+s+" to "+d);
        towerOfHanoi(e,d,s,len-1);
    }
}
