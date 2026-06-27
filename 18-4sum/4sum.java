class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;

        while (i < nums.length - 3) {
            int j = i + 1;
            while (j < nums.length - 2) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);
                        int numLeft = nums[left];
                        int numRight = nums[right];
                        while (left < right && nums[left] == numLeft) left++;
                        while (left < right && nums[right] == numRight) right--;

                    } 
                    else if (sum > target) {
                        right--;
                    }
                    else {
                        left++;
                    }
                }
                int numJ = nums[j];
                while (j < nums.length - 2 && nums[j] == numJ) j++;
            }
            int numI = nums[i];
            while (i < nums.length - 3 && nums[i] == numI) i++;
        }
        return ans;
    }
}