class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();


        int count = 0 ;
        int l = s.length();
        int i = 0;

        while(i<l){

            char c = s.charAt(i);

            if(c == '('){
                stack.push('(');
                i++;
            }else{

                if(stack.isEmpty() && i+1<l && s.charAt(i+1)==')'){
                    count++;
                    i = i+2;
                }

                else if(stack.isEmpty() && i+1<l && s.charAt(i+1)=='('){
                    count =count+2;
                    i= i+1;
                }

                else if(stack.isEmpty() && i+1>l-1){
                    count = count+2;
                    i++;
                }

                else if(i+1<l && s.charAt(i+1) == ')'){
                    i=i+2;
                    stack.pop();
                }

                else if(i+1<l && s.charAt(i+1) == '('){
                    count++;
                    i++;
                    stack.pop();
                }

                else if(i+1>l-1){
                    count++;
                    i++;
                    stack.pop();
                }
            }
        }


        return count + stack.size()*2;


    }
}