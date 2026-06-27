class Solution {
    public int numRescueBoats(int[] people, int limit) {
    
        Arrays.sort(people);
        int count = 0 ;
        int i = 0 ;
        int j = people.length-1;
        while(i<=j){
            int weight = people[i] + people[j];
            if(weight<=limit){
                i++;
            }
            count++;j--;
        }
        return count;
    }
}