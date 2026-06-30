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
                st.push(st.peek()+st.get(st.size()-2));
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