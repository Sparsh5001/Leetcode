class Solution {
    public String decodeString(String s) {
        Stack<Character>stack = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);

            if(c != ']'){
                stack.push(c);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty() && stack.peek()!='['){
                sb.append(stack.pop());   
            }
            sb.reverse();
            stack.pop();
            int multi = 0;
            int place = 1;
            while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                multi += (stack.pop() - '0') * place;
                place *= 10;
            }
            StringBuilder decoded = new StringBuilder(sb.length() * multi);
            while(multi>0){
                decoded.append(sb);
                multi--;
            }
            for (int j = 0; j < decoded.length(); j++) {
                stack.push(decoded.charAt(j));
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