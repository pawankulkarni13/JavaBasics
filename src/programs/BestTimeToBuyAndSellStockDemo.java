package programs;

/**
 * Problem 1 :
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Problem 2 :
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 *
 * Problem 3 :
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 *
 *
 */
public class BestTimeToBuyAndSellStockDemo {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int result = maxProfit(prices);
        System.out.println("Max Profit : " + result);

        //Problem 2
        result = maxProfitForAllDays(prices);
        System.out.println("Max Profit For All Days: " + result);

        //Problem 3
        result = maxProfitWithTwoTransactions(prices);
        System.out.println("Max Profit with Two Transactions: " + result);
    }

    private static int maxProfitWithTwoTransactions(int[] prices) {
        int s1 = -prices[0];
        int s2 = Integer.MIN_VALUE;
        int s3 = Integer.MIN_VALUE;
        int s4 = Integer.MIN_VALUE;

        for(int i = 1; i < prices.length; i++) {
            s1 = Math.max(s1, -prices[i]);
            s2 = Math.max(s2, s1 + prices[i]);
            s3 = Math.max(s3, s2 - prices[i]);
            s4 = Math.max(s4, s3 + prices[i]);
        }

        return Math.max(0, s4);
    }

    private static int maxProfitForAllDays(int[] prices) {
        int sum = 0;
        for(int i = 1; i < prices.length; i++){
            if( prices[i-1] > prices[i]){
                continue;
            }
            sum =  sum + prices[i]-prices[i-1] ;
        }
        return sum;
    }

    //Is typical case of maximum difference between two numbers.
    public static int maxProfit(int[] prices) {
        int min =prices[0];
        int r = -1;

        for(int ele : prices){

            min = Math.min(min, ele);
            r = Math.max(r, ele-min);
        }
        if(r == 0){
            r=0;
        }
        return r;
    }
}
