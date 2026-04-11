class Solution {
    public String makeFancyString(String s) {
        

        int l = s.length();
        if (l<3) return s;

        char one = s.charAt(0);
        char two = s.charAt(1);
        char cur;
        StringBuilder sb = new StringBuilder();
        sb.append(one).append(two);

        
        for(int i = 2 ; i<l ; i++){
            cur = s.charAt(i);

            if(cur != one){
                sb.append(cur);
            }
            else if(cur !=two){
                sb.append(cur);
            }

            one = two;
            two = cur;
        }

        String str = sb.toString();
        return str;


    }
}