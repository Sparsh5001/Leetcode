class Solution {
    public int maxArea(int[] height) {
        int i = 0 ;
        int j = height.length-1;
        int max = 0 ;
        int cur_max = 0 ;

        while (i<j){
            cur_max = (j-i)*Math.min(height[i],height[j]);
            if(cur_max > max){
                max = cur_max;
            }
            if(height[i] >= height[j]){
                j--;
            }else{
                i++;
            }
        }



    return max;

    }
}