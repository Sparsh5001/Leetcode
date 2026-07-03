class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0 ;
        for(int p : piles){
            max =Math.max(max,p);
        }
        int start = 1;
        int end = max;
        while(start<=end){
            int mid = start+(end-start)/2;
            int hours = h;
            int i = 0 ;
            while(i<piles.length){
                if(piles[i] > mid){
                    hours-=(piles[i] + mid - 1) / mid; // ceiling divison
                    i++;
                }else{
                    hours--;
                    i++;
                }
            }
            if(hours>=0){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
    return start;
    }
}