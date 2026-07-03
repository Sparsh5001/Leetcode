class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid > 0 && mid < nums.length - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid] < nums[mid + 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (mid == 0) {
                if (nums.length == 1 || nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}