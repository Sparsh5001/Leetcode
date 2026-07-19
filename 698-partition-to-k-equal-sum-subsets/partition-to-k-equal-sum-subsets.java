import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        return helper(nums, k);
    }

    public boolean helper(int[] sticks, int n) {
        boolean[] used = new boolean[sticks.length];
        int total = 0;
        for (int stick : sticks) {
            total += stick;
        }
        if (total % n != 0) {
            return false;
        }
        int req_sum = total / n;
        Arrays.sort(sticks);

        // Reverse to descending order
        for (int i = 0, j = sticks.length - 1; i < j; i++, j--) {
            int temp = sticks[i];
            sticks[i] = sticks[j];
            sticks[j] = temp;
        }
        if (sticks[0] > req_sum) {
            return false;
        }
        return solver(sticks, 0, used, 0, req_sum, 0, n);
    }

    public boolean solver(int[] sticks, int parts, boolean[] used,int cur_sum, int req_sum, int k, int n){
        if (parts == n - 1) {
            return true;
        }

        if (cur_sum == req_sum) {
            return solver(sticks, parts + 1, used, 0, req_sum, 0, n);
        }

        while (k < sticks.length) {
            if (used[k]) {
                k++;
                continue;
            }
            if (cur_sum + sticks[k] <= req_sum) {
                used[k] = true;
                if (solver(sticks, parts, used,
                           cur_sum + sticks[k], req_sum, k + 1, n)) {
                    return true;
                }
                used[k] = false;
            }
            int last = k;
            do {
                k++;
            } while (k < sticks.length - 1 &&
                     sticks[k + 1] == sticks[last]);
        }
        return false;
    }
}