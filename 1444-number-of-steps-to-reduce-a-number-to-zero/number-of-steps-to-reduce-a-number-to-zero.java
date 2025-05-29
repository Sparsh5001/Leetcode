class Solution {
    public int numberOfSteps(int num) {
        if(num < 2){
            return num;
        }
        return test(num , 0);
    }
    public int test(int n , int count){
        if(n < 2){
            count = count + n;
            return count;
        }

        else if(n%2 == 0){
            return test(n/2 , count+1);
        }

        else{
            return test(n-1 , count+1);
        }

    }
}