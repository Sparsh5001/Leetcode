class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        maker(ans,cur,s,0);
        return ans;
    }

    public void maker(List<List<String>> ans , List<String> cur , String s , int index ){

        if(index==s.length()){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int i = index ; i<s.length() ; i++){
            if(checker(s,index,i)){
                cur.add(s.substring(index,i+1));
                maker(ans,cur,s,i+1);
                cur.removeLast();
            }
        }
        return;
    }

    public boolean checker(String s , int start , int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}