class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();


        for(char c : s.toCharArray()){

            if(c == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    stack.push(')');
                }
                else if(c == ')' && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(')');
                }
            }
        }

        int count = 0 ;

        while(!stack.isEmpty()){
            count++;
            stack.pop();
        }

        return count;


    }
}