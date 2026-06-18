class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;
        int profit = 0;
        for(int i = 0 ; i < n ; i++){
            if(i+1<n && prices[i]<prices[i+1]){
                profit += prices[i+1] - prices[i];
            }
        }
    return profit;
    }
}