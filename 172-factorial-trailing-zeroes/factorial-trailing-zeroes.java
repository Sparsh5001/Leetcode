class Solution {
    public int trailingZeroes(int n) {
        if(n<5){
            return 0;
        }
        int count = 0;
        int divisor = 5;
        while(n/divisor >= 1){
            count = count + n/divisor;
            divisor = divisor*5;
        }
        return count;
    }
}