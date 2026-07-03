class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length == 1){
            return 0;
        }

        int i = 0;
        int j = 1;
        int max_profit = 0;

        while (i < j && j < prices.length){
            if(prices[j] > prices[i]){
                max_profit = Math.max(max_profit, prices[j] - prices[i]);
                j++;
            }
            else{
                i = j;
                j++;
            }
        }
        return max_profit;
    }
}
