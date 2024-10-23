package com.vaibhav.snippets.String;

import java.util.ArrayList;
import java.util.List;

public class ConcatenationExists {

        public static void main(String[] args) {
            String[] arr = new String[]{"rat", "ratmatsat", "ratmatsatgat", "matsatsat","mat", "sat", "gat", "bat", "hat"};
            System.out.println(findAll(arr));
        }

        public static List<String> findAll(String[] arr) {

            List<String> result = new ArrayList<>();

            for(int j = 0 ; j < arr.length ; j++) {
                String s = arr[j];
                int checkedLen = 0;
                int i = 0;
                int count = 0;
                int ind = 0;
                while(i<arr.length) {
                    ind = checkedLen + arr[i].length();

                    if (i != j && ind <= s.length() && s.substring(checkedLen, ind).equals(arr[i])) {
                        checkedLen = checkedLen + arr[i].length();
                        count++;
                        i = -1;
                    }

                    if (checkedLen == s.length() && count >= 2) {
                        result.add(arr[j]);
                        break;
                    }
                    i++;
                }
            }

            return result;
        }
}
