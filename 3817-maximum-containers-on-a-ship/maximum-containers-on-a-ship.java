class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int maxDeck = n*n;
        int maxSlot = maxWeight/w;
        if(maxDeck>maxSlot){
            return maxSlot;
        }
        return maxDeck;
    }
}