import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	public static String zeroCheck(int t) {
		String d;
		if(t < 10){
            d = "0"+t;
        }
        else{
            d = ""+t;
        }
		return d;
	}
	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ssa");
		Date date = new Date();
		String s = dateFormat.format(date);
		System.out.println(s);
        String d = null;
        String[] splitd = s.split(":");
        int hour = Integer.parseInt(splitd[0]);
        int minute = Integer.parseInt(splitd[1]);
        int sec = Integer.parseInt(splitd[2].substring(0,2));
        String ampm = splitd[2].substring(2,4);
        if((hour<=12) && (minute < 60) && (sec < 60)){
            
            if(ampm.equals("PM") && hour!= 12){
                hour = hour+12;
                if(hour > 24){
                    hour -= 24;
                }
            }
            if(ampm.equals("AM")&& hour == 12) {
            	hour = hour -12;	
            }
            d = zeroCheck(hour);
            d = d+ ":"+zeroCheck(minute);
            d = d+ ":"+zeroCheck(sec);
        }
        
        System.err.println(d);
	}
}
