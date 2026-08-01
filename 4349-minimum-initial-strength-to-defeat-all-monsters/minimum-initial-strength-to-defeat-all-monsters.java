class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long[] diff = new long[n + 1];

        for (int[] b : boosts) {
            diff[b[0]] += b[2];
            if (b[1] + 1 < diff.length) {
                diff[b[1] + 1] -= b[2];
            }
        }

        long[] bonus = new long[n];
        bonus[0] = diff[0];
        for (int i = 1; i < n; i++) {
            bonus[i] = bonus[i - 1] + diff[i];
        }

        long end = 0 ;
        for(long x : monsters){
            end+=x;
        }
        long start = 0 ;
        long ans = 0;

        while(start<=end){
            long mid = start+(end-start)/2;
            long curStrength = mid;
            boolean found = false;
            for(int i = 0 ; i < n ; i++){
                if(curStrength + bonus[i] >= monsters[i]){
                    curStrength -= monsters[i];
                    if(curStrength<0){
                        curStrength=0;
                    }
                    if(i==n-1){
                        found = true;
                    }
                }else{
                    break;
                }
            }
            if(!found){
                start=mid+1;
            }else{
                ans = mid;
                end = mid-1;
            }
        }
        return ans;  
    }

}
