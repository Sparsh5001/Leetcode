class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0 ;
        while(i<nums.length-2){
            int sum = 0 ;
            int j = i+1 ;
            int k = nums.length-1 ;
            while(j<k){
                sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list); 
                    int num_k = nums[k];
                    int num_j = nums[j];
                    while(num_k==nums[k] && k>i) k--;
                    while(num_j==nums[j] && j<=k) j++;      
                }
                else if(sum > 0){
                    k--;
                }
                else{
                    j++;
                }
            }
            int num_i = nums[i];
            while(i<nums.length && num_i == nums[i])i++;
        }
    return ans;
    }
}