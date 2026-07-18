class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;

        int i = 0;
        int j = 0;

        while (j < prices.length){
            int current_profit = prices[j] - prices[i];
            if (current_profit >= 0){
                max_profit = Math.max(max_profit, current_profit);
            } else {
                i = j;
            }
            j++;
        }
        return max_profit;
    }
}
