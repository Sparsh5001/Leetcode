class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0 ;
        int j = 0 ; 
        HashSet<Integer> set = new HashSet<>();
        while(j<nums.length){
            if(Math.abs(j-i)<=k){
                if(set.contains(nums[j])){
                    return true;
                }else{
                    set.add(nums[j]);
                }
                j++;
            }else{
                set.remove(nums[i]);
                i++;
            }
        }
        return false;
    }
}