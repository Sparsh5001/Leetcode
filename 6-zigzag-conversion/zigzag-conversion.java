class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        StringBuilder[] arr = new StringBuilder[numRows];
        for(int j = 0 ; j < numRows ; j++){
            arr[j] = new StringBuilder();
        }
        int i = 0;
        while(i<len){
            for(int index = 0 ; index<numRows && i<len ; index++){
                arr[index].append(s.charAt(i++));
            }

            for(int index = numRows-2 ; index>0 && i<len ; index--){
                arr[index].append(s.charAt(i++));
            }
        }

        StringBuilder ans = new StringBuilder();

        for(int j = 0 ; j < numRows ; j++){
            ans.append(arr[j]);
        }
        return ans.toString();
    }
}