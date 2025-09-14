class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        String check = s.substring(0,1);
        int max = 1;
        int i = 1;
        int j = 0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(check.indexOf(c) == -1){
                check = s.substring(j,i+1);
                i++;
                if(check.length()>max){
                    max = check.length();
                }
            }
            else{
                j++;
                check = s.substring(j,i);
                if(check.length()>max){
                    max = check.length();
                }
            }
        
    }
    return max;
    }
}