class Solution {
    public int mySqrt(int x) {
        if (x < 2){
            return x;
        } 
        int start = 1;
        int end = x/2;
        long sq=0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            sq = (long) mid * mid;
            if (sq == x) {
                return mid;
            } else if (sq < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start-1;
    }
}
