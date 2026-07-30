class Solution {
    public int minimumPushes(String word) {
        int countDifferentCharacters = 0 ;
        int keyPressed = 0;
        for(char c : word.toCharArray()){
            if(countDifferentCharacters < 8){
                keyPressed += 1;
            }
            else if(countDifferentCharacters < 16){
                keyPressed += 2;
            }
            else if(countDifferentCharacters < 24){
                keyPressed += 3;
            }
            else{
                keyPressed += 4;
            }
            countDifferentCharacters++;
        }
        return keyPressed;
    }
}