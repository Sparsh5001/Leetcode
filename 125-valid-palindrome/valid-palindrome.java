class Solution {
    public boolean isPalindrome(String s) {
        int i = 0 ; 
        int j = s.length()-1 ;
        while(i<j){
            int char_i = Character.toLowerCase(s.charAt(i));
            int char_j = Character.toLowerCase(s.charAt(j));
            if((char_i < 48 || char_i > 57) && (char_i < 97 || char_i > 122)){
                i++;
                continue;
            }
            if((char_j < 48 || char_j > 57) && (char_j < 97 || char_j > 122)){
                j--;
                continue;
            }
            if(char_i != char_j){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}