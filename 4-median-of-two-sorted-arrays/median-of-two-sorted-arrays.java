class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;
        int req = (total + 1) / 2;

        int start = 0;
        int end = m;

        while (start <= end) {

            int from1 = start + (end - start) / 2;
            int from2 = req - from1;

            int l1 = (from1 == 0) ? Integer.MIN_VALUE : nums1[from1 - 1];
            int r1 = (from1 == m) ? Integer.MAX_VALUE : nums1[from1];

            int l2 = (from2 == 0) ? Integer.MIN_VALUE : nums2[from2 - 1];
            int r2 = (from2 == n) ? Integer.MAX_VALUE : nums2[from2];

            if (l1 <= r2 && l2 <= r1) {

                if (total % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }

            } else if (l1 > r2) {
                end = from1 - 1;
            } else {
                start = from1 + 1;
            }
        }

        return -1;
    }
}