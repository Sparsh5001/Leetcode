class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int cap = capacity;
        int steps = 0;
        int next = 0;
        int n = plants.length;
        while(next<n){
            if(cap == capacity){
                cap = cap - plants[next];
                steps = steps + next + 1;
                next++;
                
            }
            if(next < n){
                if(cap >= plants[next]){
                    cap = cap - plants[next];
                    next++;
                    steps++;
                }
            }
            if(next < n){
                if(cap < plants[next]){
                    cap = capacity;
                    steps = steps + next;
                }
            }
        }
    return steps;
    }
}