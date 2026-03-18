class Solution {
    public char findKthBit(int n, int k) {
        String s = build("", n);
        return s.charAt(k - 1);
    }

    public String build(String s , int n ){
        if(n == 1){
            return "0";
        }

        String prev = build(s, n - 1);
        s = prev + "1" + rev(invert(prev));
        return s;
    }

    public String invert(String s){
        StringBuilder res = new StringBuilder();

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '0'){
                res.append('1');
            }
            else {
                res.append('0');
            }
        }
        return res.toString();
    }

    public String rev(String s){
        StringBuilder res = new StringBuilder(s);

        for(int i = 0 ; i < res.length()/2 ; i++){
            char temp = res.charAt(i);
            res.setCharAt(i, res.charAt(res.length() - i - 1));
            res.setCharAt(res.length() - i - 1, temp);
        }

        return res.toString();
    }
}