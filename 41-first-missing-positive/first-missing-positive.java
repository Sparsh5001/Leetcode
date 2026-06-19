class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i]-1;
            if(nums[i] > 0 && nums[i]<nums.length){
                if(nums[correctIndex] != nums[i] ){
                    int temp = nums[i];
                    nums[i] = nums[correctIndex];
                    nums[correctIndex] = temp;
                }else{
                    i++;
                }
            }else{
                i++;
            }
        }
        i = 0;
        while(i<nums.length){
            if(nums[i]!=i+1){
                return i+1;
            }
            i++;
        }
        return nums.length+1;






    }
}