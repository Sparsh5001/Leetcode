class Solution {
    public int numberOfSubstrings(String s) {
        int i = 0;
        int j = 0;
        int[] arr = new int[3];
        int count = 0 ;
        int ans = 0 ;

        while(j<s.length()){
            char c = s.charAt(j);
            arr[c-'a']++;
            if(arr[c-'a']==1){
                count++;
            }
            while(count==3){
                ans = ans + s.length() - j;
                char cc = s.charAt(i);
                arr[cc-'a']--;
                if(arr[cc-'a']<1){
                    count--;
                }
                i++;
            }
            j++;
        }

    return ans;
    }
}