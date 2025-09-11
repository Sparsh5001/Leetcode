class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        List<Integer> temp = new ArrayList<>();

        


        return subfind (nums , i , temp , result);
    }


    public List<List<Integer>> subfind(int[] nums , int i , List<Integer> temp , List<List<Integer>> result ){
            
            if(i == nums.length-1){
                temp.add(nums[i]);
                result.add(new ArrayList<>(temp));
                if (temp.size() > 0) temp.remove(temp.size() - 1);
            }

            else{
            temp.add(nums[i]);
            subfind(nums , i+1 , temp , result);
            }

            if(i == nums.length-1){
                result.add(new ArrayList<>(temp));
                if (temp.size() > 0) temp.remove(temp.size() - 1);
            }

            else{
                subfind(nums , i+1 , temp , result);
            }
    return result;
    }


}