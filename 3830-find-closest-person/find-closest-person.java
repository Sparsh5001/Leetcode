class Solution {
    public int findClosest(int x, int y, int z) {
        int x_dis;
        int y_dis;
        if(x<z){
            x_dis = z-x;
        }
        else{
            x_dis = x-z;
        }
        if(y>z){
            y_dis = y-z;
        }
        else{
            y_dis = z-y;
        }
        if(x_dis > y_dis){
            return 2;
        }
        else if(x_dis < y_dis){
            return 1;
        }
        return 0;
    }
}