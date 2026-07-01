class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<String> st = new Stack<>();
        int ans = 0 ;
        if(tokens.length==0){
            return 0;
        }
        if(tokens.length==1){
            return Integer.parseInt(tokens[0]);
        }

        for(String s : tokens){
            if(s.equals("*")){
                ans= Integer.parseInt(st.pop()) * Integer.parseInt(st.pop());
                st.push(Integer.toString(ans));
            }
            else if(s.equals("+")){
                ans= Integer.parseInt(st.pop()) + Integer.parseInt(st.pop());
                st.push(Integer.toString(ans));
            }
            else if(s.equals("-")){
                ans= (Integer.parseInt(st.pop()) - Integer.parseInt(st.pop()))*-1;
                st.push(Integer.toString(ans));
            }
            else if(s.equals("/")){
                int val1 = Integer.parseInt(st.pop());
                int val2 = Integer.parseInt(st.pop());
                ans= val2/val1;
                st.push(Integer.toString(ans));
            }
            else{
                st.push(s);
            }

        }
    return ans;

    }
}