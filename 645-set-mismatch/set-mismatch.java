class Solution {
    public int[] findErrorNums(int[] nums) {
        int ans[] = new int[2];
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i]-1;
            if(nums[correctIndex] != nums[i] ){
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }else{
                i++;
            }
        }
        i = 0;
        while(i<nums.length){
            if(nums[i]!=i+1){
                ans[0] = nums[i];
                ans[1] = i+1;
            }
            i++;
        }
        return ans;
    }
}