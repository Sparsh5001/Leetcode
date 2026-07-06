class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        helper(nums, used, current, ans);

        return ans;
    }

    private void helper(int[] nums, boolean[] used, List<Integer> current,List<List<Integer>> ans) {

        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            // Choose and mark it as choosen
            used[i] = true;
            current.add(nums[i]);

            // Explore now we check for remaing values and loop is used to iterate over boolean array
            helper(nums, used, current, ans);

            // Backtrack 1 element and make other combitions , untill we reach the first called loop
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}