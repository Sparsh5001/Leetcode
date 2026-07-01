class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
        int ans = 0 ;
        if(tokens.length==0){
            return 0;
        }
        for(String s : tokens){
            if(s.equals("*")){
                int val1 = st.pop();
                int val2 = st.pop();
                st.push(val1*val2);
            }
            else if(s.equals("+")){
                int val1 = st.pop();
                int val2 = st.pop();
                st.push(val1+val2);
            }
            else if(s.equals("-")){ 
                int val1 = st.pop();
                int val2 = st.pop();
                st.push(val2-val1);
            }
            else if(s.equals("/")){
                int val1 = st.pop();
                int val2 = st.pop();
                st.push(val2/val1);
            }
            else{
                st.push(Integer.parseInt(s));
            }

        }
    return st.peek();

    }
}