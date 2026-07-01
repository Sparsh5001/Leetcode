class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)) return true;
        if(s.length()!=goal.length()) return false;


        for(int i = 0 ; i < s.length()-1 ; i++){

            String sb = new String(s.substring(i+1,s.length())+s.substring(0,i+1));
            if(sb.equals(goal)) return true;

        }


    return false;

    }
}