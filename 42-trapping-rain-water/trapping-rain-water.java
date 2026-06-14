class Solution {
    public int trap(int[] height) {

        int n = height.length;
        if (n == 0) return 0;

        int[] left_max = new int[n];
        int[] right_max = new int[n];

        int cur_max = 0;

        left_max[0] = 0;

        for (int i = 1; i < n; i++) {
            if (cur_max < height[i - 1]) {
                cur_max = height[i - 1];
            }
            left_max[i] = cur_max;
        }

        cur_max = 0;

        right_max[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (cur_max < height[i + 1]) {
                cur_max = height[i + 1];
            }
            right_max[i] = cur_max;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int water = Math.min(left_max[i], right_max[i]) - height[i];

            if (water > 0) {
                ans += water;
            }
        }

        return ans;
    }
}