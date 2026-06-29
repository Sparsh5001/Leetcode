class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE ;
        int i = 0 ;
        int sum = 0 ;

        for(int j = 0 ; j<nums.length ; j++){
            sum+=nums[j];
            if(sum>=target){
                while(i<nums.length && sum>=target){
                    min = Math.min(min , Math.abs(j-i)+1);
                    sum -= nums[i];
                    i++;
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}