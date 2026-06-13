class Solution {
    public int largestRectangleArea(int[] heights) {
        

        Stack<int[]> stack = new Stack<>();
        int max = 0 ;
        int n = heights.length;
        for(int i = 0 ; i <= n ; i++){
            int height;
            if(i==n){
                 height = 0 ;
            }
            else{
                height = heights[i];
            }

            int x = 0 ;

            if(!stack.isEmpty()){
                x = stack.peek()[1] + 1;
            }

            while(!stack.isEmpty()){

                if(stack.peek()[0] >= height){
                    int cal = (x-stack.peek()[2]-1)*stack.peek()[0];
                    if (cal>max) max=cal;
                    stack.pop();
                }

                else{
                    stack.push(new int[]{height , x , stack.peek()[1]});
                    break;
                }

            }

            if(stack.isEmpty()){
                stack.push(new int[]{height , x , -1});
            }





        }

    return max ;

    }
}