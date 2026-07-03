class Solution {
    public int search(int[] nums, int target) {
        int start = 0 ;
        int end = nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target)return mid;
            if(nums[mid]>nums[end]){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        if(start==0) return binarySearch(nums,0,nums.length-1,target);
        else{
            int val = binarySearch(nums,0,start-1,target);
            int val1 = binarySearch(nums,start,nums.length-1,target);
            return Math.max(val,val1);
        }

    }
    int binarySearch(int[] nums , int start , int end , int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target)return mid;
            if(nums[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
}