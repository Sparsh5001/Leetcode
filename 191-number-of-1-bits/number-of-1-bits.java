class Solution {
    public int hammingWeight(int n) {
        int maxbit = 0;
        int count = 0;
        while(Math.pow(2,maxbit) <= n){
            maxbit++;
        }
        maxbit--;
        while(n>0){
            int max = (int)Math.pow(2,maxbit);
            if(n>=max){
                n = n - max;
                count++;
            }
            maxbit--;
        }
        return count;
    }
}