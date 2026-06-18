class Solution {
    public double angleClock(int hour, int minutes) {
        double ans = 0 ;
        double minute = minutes;
        minute = minute%60;
        double min_angle = minute*6;
        hour = hour%12;
        double hour_angle = hour*30;
        hour_angle = hour_angle +  (minute/60)*30;


        if(hour_angle > min_angle){
            double val = 360-hour_angle + min_angle;
            return Math.min(hour_angle - min_angle , val);
        }
        if(hour_angle < min_angle){
            double val = 360-min_angle + hour_angle;
            return Math.min(min_angle - hour_angle , val);
        }
    return ans;

    }
}