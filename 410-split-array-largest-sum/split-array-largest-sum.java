class Solution {
    public int splitArray(int[] nums, int k) {
        int end = 0;
        int start = 0;
        for(int n : nums){
            end += n ;
            start = Math.max(start,n);
        }
        while(start<=end){
            int mid = start+(end-start)/2;
            int sum = 0 ;
            int groups = 1;
            int i = 0 ;
            //checking how many groups it take to divide nums with set maximum limit
            while(i<nums.length){
                int w = nums[i];
                if(sum + w > mid){
                    groups++;
                    sum = w;
                    i++;
                }
                else{
                    sum = sum+w;
                    i++;
                }
            }
            //if exact or less groups used then reduce maximum to check if new lesser maximum is possible
            if (groups <= k) {
                end = mid - 1;
            } else { // if more groups used than increase maximum 
                start = mid + 1;
            }
        }
    return start;
    }
}