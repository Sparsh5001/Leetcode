class Solution {
    public int splitArray(int[] weights, int days) {
        int max=0;
        int max_el = -1;
        for(int w : weights){
            if(w>max_el){
                max_el = w;
            }
            max+=w;
        } 
        int start = max_el ;
        int end = max ;

        //finding maximum weight to allot using binary search 
        while(start<=end){
            int mid = start+(end-start)/2;
            int sum = 0 ;
            int ships = 1;
            int i = 0 ;
            
            //checking how many days it take to send weights with set maximum limit
            while(i<weights.length){
                int w = weights[i];

                if(sum + w > mid){
                    ships++;
                    sum = w;
                    i++;
                }
                else{
                    sum = sum+w;
                    i++;
                }
            }
            //if exact or less days used then reduce maximum to check if new lesser maximum is possible
            if (ships <= days) {
                end = mid - 1;
            } else { // if more days used than increase maximum 
                start = mid + 1;
            }
        }
    //start will always be at the right maximum after binary search 
    return start;
    }
}