class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        


                List<Integer> list = new ArrayList<>();
                int i = 0;
                
                while (i < nums.length) {
                    int correctIndex = nums[i]-1;
                    if (nums[i] != nums[correctIndex]) {
                        int temp = nums[i];
                        nums[i] = nums[correctIndex];
                        nums[correctIndex] = temp;
                    } else {
                        i++;
                    }
                }


                i = 0;
                while (i < nums.length) {
                    if (nums[i] != i+1) {
                        list.add(i+1);
                    }
                    i++;
                }



                return list;
    }
}