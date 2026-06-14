class Solution {
    public int maximalRectangle(char[][] matrix) {
        
    int[] heights = new int[matrix[0].length];
    for(int i = 0 ; i < heights.length ; i++){
        if(matrix[0][i] == '0'){
            heights[i] = 0;
        }else{
            heights[i] = 1;
        }
    }

    int max = 0 ;
    int cur_max = maxArea(heights);

    if (cur_max > max) max = cur_max; 
    
    for(int i = 1 ; i < matrix.length ; i++){
        for(int j = 0 ; j < matrix[0].length ; j++){
            if(matrix[i][j] == '0'){
                heights[j] = 0;
            }else{
                heights[j] += 1;
            }
        }
        cur_max = maxArea(heights);
        if (cur_max > max) max = cur_max; 
    }
    

    return max;


    }






    public int maxArea(int[] heights){
        Stack<int[]> stack = new Stack<>();

        int max = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            int height;

            if (i == n) {
                height = 0;
            } else {
                height = heights[i];
            }

            while (!stack.isEmpty()) {

                if (stack.peek()[0] >= height) {

                    int h = stack.peek()[0];
                    stack.pop();

                    int nsl = -1;

                    if (!stack.isEmpty()) {
                        nsl = stack.peek()[1];
                    }

                    int area = h * (i - nsl - 1);

                    if (area > max) {
                        max = area;
                    }

                } else {

                    if (i < n) {
                        stack.push(new int[]{height, i});
                    }

                    break;
                }
            }

            if (stack.isEmpty() && i < n) {
                stack.push(new int[]{height, i});
            }
        }

        return max;
    }
}