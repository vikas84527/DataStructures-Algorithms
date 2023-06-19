package com.learning.dsa._2.array;


//Here we are allowed to buy and sell multiple times.
//If we are allowed to buy and sell only once, then we can use the algorithm in
// Problem12_MaxDiff->maximum difference between any two elements such that larger element appears
// after the smaller number.
public class Problem10_StockBuySell {
    public static void main(String[] args) {
        int[] price = {100, 180, 260, 310, 40, 535, 695};
        int maxProfit = maxProfit(price, 0, price.length - 1);
        System.out.println(maxProfit(price));
    }

    //Maximize Profit using Valley Peak Approach (Optimal)
    private static int maxProfit(int[] price) {
        int profit = 0;
        for (int i = 1; i < price.length; i++) {
            if (price[i] > price[i - 1]) {
                profit += price[i] - price[i - 1];
            }
        }
        return profit;
    }

    private static int maxProfit(int[] price, int start, int end) {
        int maxProfit = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (price[j] > price[i]) {
                    int curr_profit = price[j] - price[i]
                            + maxProfit(price, start, i - 1)
                            + maxProfit(price, j + 1, end);

                    maxProfit = Math.max(curr_profit, maxProfit);
                }
            }
            return maxProfit;
        }
        return 0;
    }

}
