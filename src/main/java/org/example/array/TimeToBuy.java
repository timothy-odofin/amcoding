package org.example.array;

public class TimeToBuy {
    /**
     * The key here is that you'll have to buy first, before you can sell. That means, if the lower
     * price comes after a higher price, their combination won't work! Since you cannot sell first
     * before you buy it.
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minBuy) {
                minBuy = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minBuy);
            }
        }
        return maxProfit;
    }
    /**
     * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
     *
     * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
     *
     * Find and return the maximum profit you can achieve.*
     * Complexity Analysis
     *
     * Time complexity : O(n)O(n). Single pass.
     *
     * Space complexity: O(1)O(1). Constant space needed.
     * * * */
    public int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    /**
     * 309. Best Time to Buy and Sell Stock with Cooldown
     * Medium
     *
     * 6879
     *
     * 236
     *
     * Add to List
     *
     * Share
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
     *
     * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
     * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy
     * * * */
    public int maxProfitCool(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int res = 0;
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for (int i = 1; i < prices.length; i ++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i-1][0] - prices[i]);
            res = Math.max(res, dp[i + 1][0]);
            res = Math.max(res, dp[i + 1][1]);
        }
        return res;
    }

    /**
     * 714. Best Time to Buy and Sell Stock with Transaction Fee
     * Medium
     *
     * 4775
     *
     * 115
     *
     * Add to List
     *
     * Share
     * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
     *
     * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
     *
     * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
     *
     * Complexity Analysis
     *
     * Time Complexity: O(N), where NN is the number of prices.
     *
     * Space Complexity: O(1), the space used by cash and hold.*
     *  * dynamic programming
     * * **/
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    public int maxProfitV2(int[] prices, int fee) {
        int[][] dp = new int[prices.length + 1][2];
        int res = 0;
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i ++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] - prices[i] - fee);
            res = Math.max(res, dp[i + 1][0]);
            res = Math.max(res, dp[i + 1][1]);
        }
        return res;
    }
}
