class Solution {
    public long sumAndMultiply(int n) {
        
        long x = 0 ;
        long sum = 0 ;
        int i = 0;

        while(n != 0){

            int digit = n % 10;
            if(digit!=0){
                x = (long)Math.pow(10,i)*digit + x;
                sum+=digit;
                i++;
            }
            n = n/10;
        }
    return x*sum;

    }
}