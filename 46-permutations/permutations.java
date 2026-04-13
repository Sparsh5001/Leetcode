class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result  = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        find(result , cur , nums , 0);
        return result;
    }


    public void find(List<List<Integer>> result , List<Integer> cur , int[] nums , int index){

        if(index == nums.length){
            result.add(new ArrayList(cur));
            return;
        }

        for(int i = 0 ; i < cur.size() + 1 ; i++){

            cur.add(i,nums[index]);
            find(result , cur , nums , index+1);
            cur.remove(i);


        }


        return;

    }
}