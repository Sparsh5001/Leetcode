class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return helper(nums);
    }

    public List<List<Integer>> helper(int[] nums){

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        solver(ans,cur,used,nums);
        return ans;
    }

    public void solver( List<List<Integer>> ans , List<Integer> cur , boolean[] used ,int [] nums){

        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            //if duplicate found and the previous duplicate is unused than we will skip it beacuse it will generate duplicate branch , hence skip it and if previous duplicate is used than we are inside the branch hence we should include it 
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }

            // Choose and mark it as choosen
            used[i] = true;
            cur.add(nums[i]);
            
            // Explore now we check for remaing values and loop is used to iterate over boolean array
            solver(ans, cur, used , nums);

            // Backtrack 1 element and make other combitions , untill we reach the first called loop
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }
}