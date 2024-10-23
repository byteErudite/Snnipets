package com.vaibhav.snippets.codingProblems.SwappingProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NewYearEve {
    /**
     * It is New Year's Day and people are in line for the Wonderland rollercoaster ride. Each person wears a sticker indicating their initial position in the queue from  to . Any person can bribe the person directly in front of them to swap positions, but they still wear their original sticker. One person can bribe at most two others.
     *
     * Determine the minimum number of bribes that took place to get to a given queue order. Print the number of bribes, or, if anyone has bribed more than two people, print Too chaotic.
     *
     * Example
     *
     *
     * If person  bribes person , the queue will look like this: . Only  bribe is required. Print 1.
     *
     *
     * Person  had to bribe  people to get to the current position. Print Too chaotic.
     *
     * Function Description
     *
     * Complete the function minimumBribes in the editor below.
     *
     * minimumBribes has the following parameter(s):
     *
     * int q[n]: the positions of the people after all bribes
     * Returns
     *
     * No value is returned. Print the minimum number of bribes necessary or Too chaotic if someone has bribed more than  people.
     * Input Format
     *
     * The first line contains an integer , the number of test cases.
     *
     * Each of the next  pairs of lines are as follows:
     * - The first line contains an integer , the number of people in the queue
     * - The second line has  space-separated integers describing the final state of the queue.
     *
     *
     * Sample Input
     *
     * STDIN       Function
     * -----       --------
     * 2           t = 2
     * 5           n = 5
     * 2 1 5 3 4   q = [2, 1, 5, 3, 4]
     * 5           n = 5
     * 2 5 1 3 4   q = [2, 5, 1, 3, 4]
     * Sample Output
     *
     * 3
     * Too chaotic
     */


    public static void main(String[] args) throws IOException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}


class Result {

    public static void minimumBribes(List<Integer> q) {
        int[] arr = new int[q.size()];
        int ind = 0 ;
        for(int n : q) {
            arr[ind++] = n;
        }

        // Since only people can be bribed only in one direction and max twice, no person can come
        // more than two place before its original place , if that is the case , its chaotic
        for(int i = 0 ; i< q.size() ; i++) {
            if(q.get(i) > i+3) {
                System.out.println("Too chaotic");
                return;
            }
        }

        // If the swap is possible , then we just revert all the incorrect pairs ( every number who is not in
        // correct place )
        boolean isSorted = false;
        int sum = 0;
        while(!isSorted) {
            isSorted = true;
            for(int i = 0 ; i< q.size()-1 ; i++) {
                if(arr[i] > arr[i+1]) {
                    swap(i,i+1, arr);
                    sum = sum+1;
                    isSorted = false;
                }
            }

        }

        System.out.println(sum);
    }

    public static void swap(int i, int j , int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
