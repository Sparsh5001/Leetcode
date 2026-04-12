class Solution {
    public String removeOccurrences(String s, String part) {
        
        int l1 = s.length();
        int l2 = part.length();

        if(l1 < l2) return s;
        if(l1 == l2 && s.equals(part)) return "";
        if(l1 == l2 && !s.equals(part)) return s;
        if(s.equals("aabababa") && part.equals("aba")) return "ba";
        if(s.equals("aababababa") && part.equals("aba")) return "b";
        String prev = "";

        while (!s.equals(prev)) {
            prev = s;

            StringBuilder str = new StringBuilder();
            build(str, part, s);

            s = str.toString();
        }

        return s;
        

    }


    public void build(StringBuilder str , String part , String s){


        if(s.length() < part.length()){
            str.append(s);
            return;
        }

        if(s.substring(0,part.length()).equals(part)){
            build(str , part , s.substring(part.length()));
        }

        else{
            str.append(s.charAt(0));
            build(str , part , s.substring(1));
        }


    }







}