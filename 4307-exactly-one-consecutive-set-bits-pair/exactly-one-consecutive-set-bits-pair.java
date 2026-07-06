class Solution {
    public boolean consecutiveSetBits(int n) {
        String binary = Integer.toBinaryString(n);
        System.out.println(binary);
        int count = 0;
        for(int i = 0 ; i <binary.length()-1 ; i++){
            if(binary.charAt(i)=='1' && binary.charAt(i+1)=='1'){
                count++;
            }
        }
        if(count == 1){
            return true;
        }return false;
    }
}