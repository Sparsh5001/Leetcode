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
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.reverse();
        if(oddOne != 'A'){
            sb.append(oddOne);
        }
        sb.append(sb2);
        return sb.toString();
    }
}