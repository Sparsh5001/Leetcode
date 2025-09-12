class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return check(nums, target, 0, 0);
    }

    public int check(int[] nums, int target, int sum, int i) {
        
        if (i == nums.length) {
            return (sum == target) ? 1 : 0;
        }

        int add = check(nums, target, sum + nums[i], i + 1);
        int subtract = check(nums, target, sum - nums[i], i + 1);

        
        return add + subtract;
    }
}
