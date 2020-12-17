public class BuySellStockAtMostTwo {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] left = new int[n];
        int min = prices[0];
        
        
        for(int i = 1 ; i < n; i++)
        {
            left[i] = Math.max(left[i-1], prices[i] - min);
            min = Math.min(prices[i], min);
            
        }
        
        int[] right = new int[n];
        int max = prices[n-1];
        int profit = 0;
        
        for(int i = n-2 ; i >= 0 ; i--)
        {
            right[i] = Math.max(right[i+1], max- prices[i]);
            max = Math.max(max, prices[i]);
            
            profit = Math.max(profit ,left[i] + right[i]);
        }
        
        return profit;
    }
}
