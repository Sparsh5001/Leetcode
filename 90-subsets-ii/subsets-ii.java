class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        return helper(nums);
    }

    public List<List<Integer>> helper(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        buildSets(nums , 0 , ans , list  );
        return ans;
    }

    public void buildSets( int[]nums , int i , List<List<Integer>> ans , List<Integer> list ){
        if(i==nums.length){
            ans.add(new ArrayList<>(list)); 
            return;
        }

        list.add(nums[i]); 
        buildSets(nums , i+1 , ans , list );

        list.remove(list.size()-1);
        int idx = i+1;
        while(idx!=nums.length && nums[idx-1]==nums[idx]){
            idx++;
        }
        buildSets(nums , idx , ans , list );

    }
}