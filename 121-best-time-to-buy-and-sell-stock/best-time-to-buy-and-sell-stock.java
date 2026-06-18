class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length == 1) return 0;
        int[] sell = new int[prices.length]; 

        int max = 0 ;
        for(int i = prices.length-2 ; i > -1 ; i--){
            sell[i] = Math.max(prices[i+1] , max);
            max = sell[i];
        }
        int ans=0;
        for(int i = 0 ; i < sell.length ; i++){
            ans = Math.max(ans , sell[i]-prices[i]);
        }
        return ans;
    }
}