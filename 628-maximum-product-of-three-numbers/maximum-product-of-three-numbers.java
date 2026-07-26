class Solution {
    public int maximumProduct(int[] nums) {
        if(nums.length==3){
            return nums[0]*nums[1]*nums[2];
        }
        Arrays.sort(nums);
        int productNeg = nums[0]*nums[1]*nums[nums.length-1];
        int productPos = nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1];
        return Math.max(productNeg , productPos);
    }
}