class Solution {
    public int maxDistance(int[] position, int m) {
        int end = 0;
        for(int p : position){
            if(p>end){
                end=p;
            }
        }
        int start = 1;
        Arrays.sort(position);
        if(m==2){
            return position[position.length-1]-position[0];
        }
        while(start<=end){

            int mid = start+(end-start)/2;
            int balls = 1;
            int i = 1;
            int force = position[0];

            while(i<position.length){
                int p = position[i];

                if(Math.abs(p-force) >= mid){
                    balls++;
                    force = p;
                }
                i++;
            }
            if(balls>=m){
                start = mid+1;
            }else{
                end = mid-1;
            }

        }
        return end;
    }
}