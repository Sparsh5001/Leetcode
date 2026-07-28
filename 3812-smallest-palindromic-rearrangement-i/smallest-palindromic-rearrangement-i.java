class Solution {
    public String smallestPalindrome(String s) {
        int[] bucket = new int[26];
        for(char c : s.toCharArray()){
            bucket[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();

        char oddOne = 'A';
        boolean t = true;

        for(int i = 0 ; i<26 ; i++){
            char ch = (char)('a'+i);
            if(t && bucket[i] % 2 == 1){
                oddOne = ch;
                t=false;
            }
            int x = bucket[i]/2;
            for (int j = 0; j < x; j++) {
                sb.append(ch);
            }
        }
        if(oddOne != 'A'){
            sb.append(oddOne);
        }
        for(int i = 25 ; i>-1 ; i--){
            char ch = (char)('a'+i);
            int x = bucket[i]/2;
            for (int j = 0; j < x; j++) {
                sb.append(ch);
            }
        }

        return sb.toString();
        
    }
}