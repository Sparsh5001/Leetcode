import java.util.*;

class Solution {

    long LIMIT;

    public String smallestPalindrome(String s, int k) {
        LIMIT = k;

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] half = new int[26];
        char mid = 0;
        int halfLen = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            halfLen += half[i];
            if ((freq[i] & 1) == 1) {
                mid = (char) ('a' + i);
            }
        }

        if (countWays(half, halfLen) < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0)
                    continue;

                half[c]--;

                long cnt = countWays(half, halfLen - pos - 1);

                if (cnt >= k) {
                    left.append((char) ('a' + c));
                    break;
                }

                k -= cnt;
                half[c]++;
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);

        if (mid != 0)
            ans.append(mid);

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private long countWays(int[] freq, int len) {

        long ans = 1;
        int remaining = len;

        for (int i = 0; i < 26; i++) {

            int f = freq[i];
            if (f == 0)
                continue;

            ans = multiplyChoose(ans, remaining, f);

            if (ans >= LIMIT)
                return LIMIT;

            remaining -= f;
        }

        return Math.min(ans, LIMIT);
    }

    private long multiplyChoose(long cur, int n, int r) {

        if (r == 0)
            return cur;

        r = Math.min(r, n - r);

        long res = cur;

        for (int i = 1; i <= r; i++) {

            long num = n - r + i;
            long den = i;

            long g = gcd(num, den);
            num /= g;
            den /= g;

            g = gcd(res, den);
            res /= g;
            den /= g;

            if (res > LIMIT / num)
                return LIMIT;

            res *= num;
            res /= den;

            if (res >= LIMIT)
                return LIMIT;
        }

        return Math.min(res, LIMIT);
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}