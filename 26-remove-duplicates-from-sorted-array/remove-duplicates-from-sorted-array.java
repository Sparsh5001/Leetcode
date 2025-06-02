class Solution {
    public int removeDuplicates(int[] nums) {
    int previous = -101;
    int place = 0;
    int count = 0;
    for(int i=0 ; i<nums.length ; i++){
        if(nums[i]!=previous){
            previous = nums[i];
            nums[place] = nums[i];
            place++;
            count++;
        }
    }
    return count;

    }
}
