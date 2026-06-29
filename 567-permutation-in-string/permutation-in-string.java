class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int size = s1.length();
        int[] arr = new int[26];
        int d = 0;

        if(size>s2.length()) return false;

        for(int i = 0 ; i < size ; i++){
            char c = s1.charAt(i);
            arr[c - 'a']++;
            if(arr[c - 'a'] ==1 ){
                d++;
            }
        }

        int i =0;
        int j =0;

        while(j<i+size){
            char c = s2.charAt(j);
            if(s1.indexOf(c)!=-1){
                arr[c-'a']--;
                if(arr[c-'a']==0){
                    d--;
                }
            }
            j++;
        }
        if(d==0) return true;
        i++;

        while(j<s2.length()){
            char c_n = s2.charAt(j);
            char c_o = s2.charAt(i-1);

            if(s1.indexOf(c_o)!=-1){
                arr[c_o - 'a']++;
                if(arr[c_o - 'a'] == 1){
                    d++;
                }
            }

            if(s1.indexOf(c_n)!=-1){
                arr[c_n - 'a']--;
                if(arr[c_n - 'a']==0){
                    d--;
                }
            }
            if(d==0){
                return true;
            }

            i++;j++;
        }

    return false;
    }
}