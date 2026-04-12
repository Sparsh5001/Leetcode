class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        find(result , cur , candidates , target , 0 , 0);
        return result;

    }


    public void find( List<List<Integer>> result , List<Integer> cur ,int[] candidates , int target , int index , int cur_sum ){


        if(index == candidates.length){
            if(cur_sum == target){
                result.add(new ArrayList<>(cur));
                return;
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
        find(result , cur , candidates , target , index  , cur_sum);
        cur_sum -= candidates[index];
        cur.remove(cur.size() - 1);
        find(result , cur , candidates , target , index + 1 , cur_sum);



    }


}