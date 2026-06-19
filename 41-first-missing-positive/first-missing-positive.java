class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        for(int i = 1; i<=Integer.MAX_VALUE ; i++){
            if(!set.contains(i)) return i;
        }
        return 0;
    }
}