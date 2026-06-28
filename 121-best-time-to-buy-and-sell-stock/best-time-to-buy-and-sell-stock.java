class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0 ;

        int i = 0 ;
        int j = 0 ;

        while(j<prices.length){
            int cur = prices[j] - prices[i];
            if(cur<0){
                i++;
            }else{
                profit = Math.max(profit,cur);
                j++;
            }
        }
    return profit;
    }
}