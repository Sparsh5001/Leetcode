class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0){
            return 0; 
        }

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
        int cur_length=1;
        int max=1;
        for(int n : set){
            if(set.contains(n-1)){
                continue;
            }else{
                int i = n;
                while(set.contains(i+1)){
                    cur_length++;
                    i++;
                }
                max = Math.max(cur_length , max);
                cur_length = 1;
            }
        }
    return Math.max(cur_length , max);
    }
}