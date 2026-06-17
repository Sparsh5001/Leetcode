class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int i = 0 ; // iterator
        int j = 0 ; // insert position of 0
        int k = n-1; // insert position of 2

        while(i<=k && k>-1){

            if(nums[i]==0){
                nums[i] = 1;
                nums[j] = 0;
                i++;
                j++;
            }

            else if(nums[i]==2){
                if(nums[k]==2){
                    k--;
                }else{
                    int temp = nums[k];
                    nums[k] = 2;
                    nums[i] = temp;
                    if(temp == 1){
                        k--;
                        i++;
                    }else{
                        if(i!=j){
                            nums[j] = 0;
                            nums[i] = 1;
                        }
                        i++;
                        j++;
                        k--;
                    }
                }
            }

            else if(nums[i]==1){
                i++;
            }
        }
    }
}