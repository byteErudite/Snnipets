package com.vaibhav.snippets.new_problems;

public class BestTimeToBuySellStock {
    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     *
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     *
     *
     *
     * Example 1:
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     * Example 2:
     *
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transactions are done and the max profit = 0.
     *
     *
     * Constraints:
     *
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     */

    public static void main(String[] args) {
        int[] testCase1 = new int[] {7,1,5,3,6,4}; // output expected : 5
        int[] testCase2 = new int[]{7,6,4,3,1}; // output expected : 0
        String result1 = maxProfit_1(testCase1) == 5 ? "passed" : "failed";
        String result2 = maxProfit_1(testCase2) == 0 ? "passed" : "failed";
        System.out.println("Test case 1 "+result1);
        System.out.println("Test case 2 "+result2);
    }
    public static int maxProfit_1(int[] prices) {
        // Strategy : initialise start and end with first element
        // if end is greater than start then find the profit and assign to  maxProfit till now . increment only end
        // if end is smaller than start then move start to end and increment end
        int maxProfitTillNow = 0;
        int start = 0;
        int end = 0;
        while(end < prices.length) {
            int profit = prices[end] - prices[start];
            if (profit < 0) {
                start = end;
            } else {
                if(profit > maxProfitTillNow) {
                    maxProfitTillNow = profit;
                }
            }
            end++;
        }
        return maxProfitTillNow;
    }
}
