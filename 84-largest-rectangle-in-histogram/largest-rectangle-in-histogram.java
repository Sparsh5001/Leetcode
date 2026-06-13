class Solution {
    public int largestRectangleArea(int[] heights) {

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