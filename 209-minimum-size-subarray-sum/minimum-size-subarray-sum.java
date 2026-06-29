class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE ;
        int i = 0 ;
        int j = 0 ;
        int start = 0 ;
        int end = 0 ;
        int sum = 0 ;

        while(j<nums.length){
            sum+=nums[j];
            if(sum<target){
                j++;
            }else{
                while(i<nums.length && sum>=target){
                    sum -= nums[i];
                    i++;
                }
                start = i-1;
                end = j;
                min = Math.min(min , Math.abs(end-start)+1);
                j++;
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}