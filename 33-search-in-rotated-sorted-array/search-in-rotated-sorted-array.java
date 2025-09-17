class Solution {
    public int search(int[] nums, int target) {
        return find(nums , target , 0 , nums.length-1);
    }


    public int find(int[] nums , int target , int s , int e){
        if (s > e) return -1;
        int mid = s + (e-s)/2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[mid] >= nums[s]){
            if(nums[s] <= target && target <= nums[mid]){
                return find(nums , target , s , mid-1);
            }
            else{
                return find(nums , target , mid+1 , e);
            }
        }
        else {
            if(nums[mid] <= target && target <= nums[e]){
                return find(nums, target, mid+1, e);
            } else {
                return find(nums, target, s, mid-1);
            }
        }
    }
}