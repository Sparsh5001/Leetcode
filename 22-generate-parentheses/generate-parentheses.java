class Solution {
    public List<String> generateParenthesis(int n) {
        return helper(n);
    }

    public List<String> helper(int n){
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int open = n;
        int close = n;

        solver(open , close , ans , sb);
        return ans;
    }

    public void solver(int open , int close , List<String> ans , StringBuilder sb){

        if(open==0 && close==0){
            ans.add(sb.toString());
            return;
        }

        if(open>close){
            return;
        }

        if(open>0){
            sb.append('(');
            solver(open-1 , close , ans , sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close>open){
            sb.append(')');
            solver(open , close-1 , ans , sb);
            sb.deleteCharAt(sb.length() - 1);
        } 





    }


}