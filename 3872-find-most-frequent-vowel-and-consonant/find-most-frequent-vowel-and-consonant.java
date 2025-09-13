class Solution {
    public int maxFreqSum(String s) {
        int arr[] = new int[26];
        
        int i = 0;
        int vmax = 0;
        int cmax = 0;
        while(i<s.length()){
            int A = (int) s.charAt(i);
            A = A % 97;
            arr[A] = arr[A] + 1;
            i++;
        }
        i = 0 ;
        while(i<26){
            if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20){
                if(vmax<arr[i]){
                vmax = arr[i];
            }
            }

            else if(cmax<arr[i]){
                cmax = arr[i];
            }
            i++;

        }



        return vmax+cmax;

    }
}