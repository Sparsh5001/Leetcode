class Solution {
    public String makeFancyString(String s) {
        

        int l = s.length();
        if (l<3) return s;

        char cur;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0)).append(s.charAt(1));

        
        for(int i = 2 ; i<l ; i++){
            cur = s.charAt(i);

            if(cur != s.charAt(i-1)){
                sb.append(cur);
            }
            else if(cur != s.charAt(i-2)){
                sb.append(cur);
            }

        }

        String str = sb.toString();
        return str;


    }
}