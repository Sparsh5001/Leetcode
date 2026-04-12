class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        find(result , cur , 0 , nums);
        return result;
    }

    public void find(List<List<Integer>> result , List<Integer> cur , int index , int[] nums){
        if(index == nums.length){
            result.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);              
        find(result, cur, index + 1, nums); 
        cur.remove(cur.size() - 1);   
        find(result, cur, index + 1, nums); 
    }
}