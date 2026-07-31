class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        int pushes = 0;
        int pushed = 0;
        for(char c : word.toCharArray()){
            freq[c-'a']++;
        }
        Arrays.sort(freq);

        for(int i = 25 ; i>=0 ; i--){
            if(freq[i]>0){
                if(pushed<8){
                    pushes += freq[i];
                }
                else if (pushed<16){
                    pushes += freq[i]*2;
                }
                else if(pushed<24){
                    pushes += freq[i]*3;
                }
                else{
                    pushes += freq[i]*4;
                }
                pushed++;
            }
        }
        return pushes;
    }
}