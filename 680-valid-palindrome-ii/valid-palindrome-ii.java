class Solution {
    public boolean validPalindrome(String s) {

        int i = 0 ; 
        int j = s.length()-1 ;
        while(i<j){
            int char_i = s.charAt(i);
            int char_j = s.charAt(j);
            if(char_i != char_j){
               return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1) ;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }
            return true;
        }
}