class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max = -2147483648;
        int sum = 0;
        int i = 0;
        while(i<k){
            sum += nums[i];
            i++;
        }
        if(sum>max){
            max = sum;
        }
        if(k<nums.length){
            i = k;
        }
        while(i<nums.length){
            sum += nums[i];
            sum -= nums[i-k];
            if(sum>max){
                max = sum;
            }
            i++;
        }
        double ans =  (double) max/k;
        return ans;

    }
}