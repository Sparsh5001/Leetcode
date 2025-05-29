class Solution {
    public boolean isPowerOfTwo(int n) {
        return check(n , 1);
    }

    public boolean check(int n , int x){
        if(x==n){
            return true;
        }

        else if(x>n || x > Integer.MAX_VALUE / 2){
            return false;
        }

        else{
            return check(n , x*2);
        }

    }
}