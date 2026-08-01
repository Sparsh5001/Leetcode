class Solution {
    public int countValidPrefixes(String s) {
        int[] freq = new int[2];
        int ans = 0;
        for(char c : s.toCharArray()){
            if(c=='0'){
                freq[0]++;
            }else{
                freq[1]++;
            }
            if(Math.abs(freq[0]-freq[1])<=1){
                ans++;
            }
        }
        return ans;
    }
}