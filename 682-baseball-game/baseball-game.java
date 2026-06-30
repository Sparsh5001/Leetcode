class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int sum = 0 ;
        for(String s: operations){
            if(s.equals("C")){
                sum -= st.peek();
                st.pop();
            }
            else if(s.equals("D")){
                st.push(2*st.peek());
                sum+=st.peek();
            }
            else if(s.equals("+")){
                int val1 = st.peek();
                st.pop();
                int val2 = st.peek();
                st.push(val1);
                st.push(val1+val2);
                sum+=st.peek();
            }
            else{
                st.push(Integer.parseInt(s));
                sum+=st.peek();
            }
        }
    return sum;
    }
}