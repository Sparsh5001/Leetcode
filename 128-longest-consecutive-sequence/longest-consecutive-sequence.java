class Solution {
    public int longestConsecutive(int[] nums) {
    Arrays.sort(nums);
    int longest = 1;
    int cur_long = 1;
    if(nums.length == 0) return 0;

    for(int i = 1 ; i < nums.length ; i++){
        if(nums[i]==nums[i-1]+1){
            cur_long++;
        }
        else if(nums[i]==nums[i-1]){
            continue;
        }
        else{
            longest = Math.max(longest, cur_long);
            cur_long = 1;
        }
    }
    return Math.max(cur_long , longest);

    }
}