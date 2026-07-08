class Solution {
    public int kthGrammar(int n, int k) { 
        return solver(n,k);
    }

    public int solver(int n , int k ){

        if(n==1){
            return 0;
        }

        int len = (int)Math.pow(2,n-1);

        if(k>len/2){
            return (solver(n-1,k-len/2)+1)%2;
        }else{
            return solver(n-1,k);
        }

    }
}