class Solution {
    public int search(int[] nums, int target) {
        int peak = findpeak(nums);
        int firsttry = tryfirst(nums , target , 0 , peak-1);
        if(firsttry!=-1){
            return firsttry;
        }

        int secondtry = tryfirst(nums , target , peak , nums.length-1);
        return secondtry;
    }


    int findpeak(int[] nums){
        int start = 0;
        int end = nums.length-1;
        int mid=0;
        while(start<end){
            mid = start + (end-start)/2;
                if(nums[mid]>nums[end])
                {
                   start = mid+1;
                }
                else
                {
                    end = mid;
                }
        }
        return start;
}

int tryfirst(int[]nums , int target , int start , int end ){
        int mid = 0;
        while(start<=end)
        {
            mid = start + (end-start)/2;
            if(nums[mid]==target)
                {
                    return mid;
                }  
            else if(nums[mid]>target)
            {
                end = mid-1;
            }   
            else if(nums[mid]<target)
            {
                start = mid+1;
            }    
        }
        return -1;
}


}
