class Solution {
    public int maximum69Number (int num) {
        int length = String.valueOf(num).length();
        int result = (int) Math.pow(10, length-1);
        int temp = num;
        while(result >= 1){
            if(temp / result == 6){
                return num + 3*result;
            }
            temp  = temp % result ;
            result = result / 10;
        }
        return num;
    }
}