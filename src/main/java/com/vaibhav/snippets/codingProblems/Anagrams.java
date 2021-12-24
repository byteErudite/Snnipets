package com.vaibhav.snippets.codingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Anagrams {

    /*
    Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.

    Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'

    Note:  All inputs will be in lower-case.

    Example :

    Input : cat dog god tca
    Output : [[1, 4], [2, 3]]
    cat and tca are anagrams which correspond to index 1 and 4.

    dog and god are another set of anagrams which correspond to index 2 and 3.

    The indices are 1 based ( the first element has index 1 instead of index 0).

    Ordering of the result : You should not change the relative ordering of the words / phrases within the group. Within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.
     */

    public static String sortString(String inputString)
    {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        List<String> sortedA = new ArrayList<>();
        for (int i = 0 ; i< A.size() ; i++) {
            sortedA.add(sortString(A.get(i)));
        }
        Map<String, List<Integer>> stringByIndices = new HashMap<>();
        for(int i = 0 ; i< sortedA.size() ; i++) {
            String currentString = sortedA.get(i);
            if(stringByIndices.containsKey(currentString)) {
                List<Integer> indices = stringByIndices.get(currentString);
                indices.add(i + 1);
                stringByIndices.put(currentString,indices);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i + 1);
                stringByIndices.put(currentString,indices);
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Iterator stringByIndicesIterator = stringByIndices.entrySet().iterator();

        while (stringByIndicesIterator.hasNext()) {
            Map.Entry mapElement
                    = (Map.Entry)stringByIndicesIterator.next();
            ArrayList<Integer> indices = (ArrayList<Integer>) mapElement.getValue();
            result.add(indices);
        }
        return result;
    }
}
