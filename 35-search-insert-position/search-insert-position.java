class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int start = 0 ;
        int end = n-1;
        int mid=0;
        while(start<=end){
            mid = start+(end-start)/2;
            if(target==nums[mid])return mid;
            else if(target>nums[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        if(nums[mid]>target) return mid;
        return mid+1;
    }
}