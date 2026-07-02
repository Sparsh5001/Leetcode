class Solution {
    public String decodeString(String s) {
        Stack<Character>stack = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);

            if(c != ']'){
                stack.push(c);
                continue;
            }
            String temp="";
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty() && stack.peek()!='['){
                sb.append(stack.pop());   
            }
            temp = sb.toString(); 
            stack.pop();
            int multi = 0;
            int place = 1;
            while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                multi += (stack.pop() - '0') * place;
                place *= 10;
            }
            while(multi>1){
                sb = sb.append(temp);
                multi--;
            }
            int len = sb.length();
            for(int j = len-1 ; j > -1 ; j--){
                stack.push(sb.charAt(j));
            }
        }
    StringBuilder sb = new StringBuilder();
    while(!stack.isEmpty()){
        sb.append(stack.pop());
    }
    sb.reverse();
    return sb.toString();
    }
}