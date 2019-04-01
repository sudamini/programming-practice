package com.arrays;

public class StockBuySellOnce {

    public static void main(String[] args) {
        int[] arr = new int[]{
                310, 315, 275, 295, 260, 270, 290, 230, 255, 250
        };
        System.out.println(findMaxProfitBruteForce(arr));
        System.out.println(findMaxProfitOneIteration(arr));
    }

    /*
    Uses two for loops and O(n2)
     */
    private static int findMaxProfitBruteForce(int[] arr) {
        int max_profit = Integer.MIN_VALUE;
        int buy_price, sell_price, profit;
        for (int i = 0; i < arr.length; i++) {
            buy_price = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                sell_price = arr[j];
                if (sell_price < buy_price) {
                    continue;
                }
                profit = sell_price - buy_price;
                max_profit = Integer.max(profit, max_profit);
            }
        }
        System.out.println(max_profit);
        return max_profit;
    }

    /*
    O(n) one iteration
     */
    private static int findMaxProfitOneIteration(int[] arr) {
        int max_profit = Integer.MIN_VALUE;
        int minSoFar = Integer.MAX_VALUE;
        int profit;
        for (int i = 0; i < arr.length; i++) {
            minSoFar = Integer.min(arr[i], minSoFar);
            profit = arr[i] - minSoFar;
            max_profit = Integer.max(max_profit, profit);
        }
        System.out.println(max_profit);
        return max_profit;

    }


}
