class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for(int b : bloomDay){
            start = Math.min(start , b);
            end = Math.max(end , b);
        }
        int check = end;

        while(start<=end){
            int mid = start+(end-start)/2;
            int made = 0 ;
            int count = 0 ;
            for(int flower : bloomDay){
                if(flower<=mid){
                    count++;
                    if(count==k){
                        made++;
                        count=0;
                    }
                }else{
                    count=0;
                }
            }
            if(made >= m){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        if(start>check){
            return -1;
        }

    return start;
    }
}