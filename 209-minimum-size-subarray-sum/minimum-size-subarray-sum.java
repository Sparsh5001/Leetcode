class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE ;
        int i = 0 ;
        int j = 0 ;
        int sum = 0 ;

        while(j<nums.length){
            sum+=nums[j];
            if(sum>=target){
                while(i<nums.length && sum>=target){
                    sum -= nums[i];
                    i++;
                }
                min = Math.min(min , Math.abs(j-i+1)+1);
            }
            j++;
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}