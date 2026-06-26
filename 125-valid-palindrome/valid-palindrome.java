class Solution {
    public boolean isPalindrome(String s) {
        int i = 0 ; 
        int j = s.length()-1 ;
        while(i<j){
            int char_i = Character.toLowerCase(s.charAt(i));
            int char_j = Character.toLowerCase(s.charAt(j));
            if(!Character.isLetterOrDigit(char_i)){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(char_j)){
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