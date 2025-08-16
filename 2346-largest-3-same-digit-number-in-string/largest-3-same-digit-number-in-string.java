class Solution {
    public String largestGoodInteger(String num) {
        int l = num.length();
        int i = 0;
        int max = -1;  
        
        while (i < l) {
            if (i + 2 < l) {
                if (num.charAt(i) != num.charAt(i + 1)) {
                    i++;
                }
                 else if (num.charAt(i + 1) != num.charAt(i + 2)) {
                    i = i + 2;
                } 
                else {
                    int digit = num.charAt(i) - '0';
                    if (digit > max) {
                        max = digit;
                    }
                    i = i + 3;
                }
            }
            else {
                i++;
            }
        }
        
        if (max == -1) {
            return "";
        }
        
        String s = String.valueOf(max);
        return s + s + s;
    }
}
