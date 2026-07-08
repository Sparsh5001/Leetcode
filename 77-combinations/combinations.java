class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return helper(n , k);
    }
    public List<List<Integer>> helper(int n , int k){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        combinations(ans,cur,1,n,k);
        return ans;
    }
    public void combinations(List<List<Integer>> ans , List<Integer> cur , int index , int n , int k){
        if(cur.size()==k){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = index ; i <= n ; i++){
            cur.add(i);
            combinations(ans,cur,i+1,n,k);
            cur.remove(cur.size()-1);
        }
    return;
    }

}