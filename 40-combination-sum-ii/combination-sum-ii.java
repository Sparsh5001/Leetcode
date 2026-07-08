class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        find(result , cur , candidates , target , 0 , 0);
        return result;
    }

    public void find( List<List<Integer>> result , List<Integer> cur ,int[] candidates , int target , int index , int cur_sum ){

            if(index==candidates.length){
                if(cur_sum == target){
                    result.add(new ArrayList<>(cur));
                }
                return;
            }

            if(cur_sum == target){
                result.add(new ArrayList<>(cur));
                return;
            }

            if(cur_sum > target){
                return;
            }

            cur_sum += candidates[index];
            cur.add(candidates[index]);
            find(result , cur , candidates , target , index+1 , cur_sum);
            cur.remove(cur.size()-1);
            cur_sum -= candidates[index];
            int idx = index+1;
            while(idx !=candidates.length && candidates[idx]==candidates[idx-1]){
                idx++;
            }
            find(result , cur , candidates , target , idx , cur_sum);

        return;
    }
}