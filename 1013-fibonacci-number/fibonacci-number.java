class Solution {
    public int fib(int n) {
        return fibtry(n);
    }


    int fibtry(int n){
        if(n<2){
            return n;
        }
        return fibtry(n-1) + fibtry(n-2);
        

    }


}