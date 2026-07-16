class Solution {
    public List<String> restoreIpAddresses(String s) {
        return helper( s);
    }


    public List<String> helper(String s ){
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solver(ans , sb , s , 0 , 0);
        return ans;
    }


    public void solver(List<String> ans,StringBuilder sb,String s , int i , int segments){

        if(i==s.length() && segments==4){
            sb.setLength(sb.length()-1);
            ans.add(sb.toString());
            sb.append('.');
            return;
        }

        if(segments==4){
            return;
        }

        for(int len = 1 ; len<=3 ; len++){
            if(i+len>s.length()){
                return;
            }
            String segment = s.substring(i,i+len);
            if(Integer.parseInt(segment)<=255){
                if(segment.length()>1 && segment.charAt(0)=='0'){
                    return;
                }
                int l = sb.length();
                sb.append(segment+'.');
                solver(ans,sb,s,i+len,segments+1);
                sb.setLength(l);
            }
            
        }
    }
}