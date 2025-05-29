class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<1){
            return false;
        }
        return check(n , 1);
    }

    public boolean check(int n , int x){
        if(x==n){
            return true;
        }

        else if(x>n || x > Integer.MAX_VALUE / 4){
            return false;
        }

        else{
            return check(n , x*4);
        }

    }
}


