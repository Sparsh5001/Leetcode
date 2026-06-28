class Solution {
    public int lengthOfLongestSubstring(String s) {
       int[] arr = new int[128];
       int i = 0 ; 
       int j = 0 ; 
       int max = 0 ;

       while(j<s.length()){
            char c = s.charAt(j);
            arr[(int)c]++;
            if(arr[(int)c] == 1){
                max = Math.max(max , j-i+1);
                j++;
                continue;
            }
            while(i<j && arr[(int)s.charAt(j)] > 1){
                i++;
                arr[(int)s.charAt(i-1)]--;
            }
            max = Math.max(max , j-i+1);
            j++;
       }
    return max;
    }
}