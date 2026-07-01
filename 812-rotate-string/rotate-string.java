class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0 ;
        while(i<s.length()){
            sb = rotate(sb,1,s.length()-1);
            sb = rotate(sb,0,s.length()-1);
            String check = sb.toString();
            if(check.equals(goal)){
                return true;
            }
            i++;
            System.out.println(sb);
        }
        
        return false;
    }

    public StringBuilder rotate(StringBuilder sb , int start , int end){
        while(start<end){
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
        return sb;
    }
}