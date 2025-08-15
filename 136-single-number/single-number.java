class Solution {
    public int singleNumber(int[] nums) {
        sort(nums);
        int i = 0;
        while(i<nums.length-1){
            if(nums[i]==nums[i+1]){
                i = i+2;
                continue;
            }
            else{
                return nums[i];
            }
        }
        int l = nums.length;
        return nums[l-1];



    }



    public void sort(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }
}









    
