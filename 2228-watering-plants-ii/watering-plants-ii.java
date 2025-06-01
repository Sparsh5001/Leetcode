class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int a = 0;
        int b = n-1;
        int capA = capacityA;
        int capB = capacityB;
        int time =0;
        while(a<b){
            if (capA < plants[a]) {
                capA = capacityA;
                time++;
            }
            capA -= plants[a];
            a++;

            if (capB < plants[b]) {
                capB = capacityB;
                time++;
            }
            capB -= plants[b];
            b--;
            
        }
        if(a==b){
                if(capA>=plants[a] || capB>=plants[b]){
                    return time;
                }
                else{
                    return time+1;
                }
                
            }


        return time;

    }
}