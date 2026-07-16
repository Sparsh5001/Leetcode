class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

            solver(ans,sb,0,0,0,target,num);
        
 
        return ans;
    }


    public void solver(List<String> ans , StringBuilder sb , int i  ,long val , long prev , int target , String num){

        if(i==num.length() && val==target){
            ans.add(sb.toString());
            return;
        }

        if(i==num.length()){
            return;
        }


        for(int len = i+1 ; len <= num.length() ; len++){
            if (len > i + 1 && num.charAt(i) == '0'){break;}
            
            String number = num.substring(i,len);
            long numb = Long.parseLong(number);
            int oldlen = sb.length();

            if (i == 0) {
                sb.append(number);
                solver(ans, sb, len, numb , numb, target, num);
                sb.setLength(oldlen);
            }else{
                sb.append("+" + number);
                solver(ans,sb,len,val+numb,numb,target,num);
                sb.setLength(oldlen);

                sb.append("-" + number);
                solver(ans,sb,len,val-numb,-numb,target,num);
                sb.setLength(oldlen);

                sb.append("*" + number);
                solver(ans,sb,len,val-prev+prev*numb,prev*numb,target,num);
                sb.setLength(oldlen);
            }
        }
    }
}