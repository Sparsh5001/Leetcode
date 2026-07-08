class Solution {

    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // 1. Prefix digit sum
        int[] prefixSum = new int[n + 1];

        // 2. Powers of 10
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // 3. Non-zero positions
        int[] pos = new int[n];

        // 4. Prefix concatenated number
        long[] prefixNum = new long[n];

        int cnt = 0;
        long cur = 0;

        for (int i = 0; i < n; i++) {

            int digit = s.charAt(i) - '0';

            prefixSum[i + 1] = prefixSum[i] + digit;

            if (digit != 0) {
                pos[cnt] = i;
                cur = (cur * 10 + digit) % MOD;
                prefixNum[cnt] = cur;
                cnt++;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            long sum = prefixSum[r + 1] - prefixSum[l];

            int left = lowerBound(pos, cnt, l);
            int right = upperBound(pos, cnt, r) - 1;

            if (left > right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left + 1;

            long x = prefixNum[right];

            if (left > 0) {
                x = (x - (prefixNum[left - 1] * pow10[len]) % MOD + MOD) % MOD;
            }

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }

    // First index >= target
    private int lowerBound(int[] arr, int size, int target) {

        int lo = 0, hi = size;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] < target)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }

    // First index > target
    private int upperBound(int[] arr, int size, int target) {

        int lo = 0, hi = size;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] <= target)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }
}