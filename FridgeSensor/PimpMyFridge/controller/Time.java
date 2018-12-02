
public class Time {
	//returns time in a display format
	public static String getTime(long time) {
		time = time / 1000;
		
		//number of ms in a day
		double temp = time / (3600 * 24);
		temp = (long) Math.floor(temp);
		
		time = (long) ((long) time - (temp * 3600 * 24));
		
		//time is in seconds
		int hours    = 0;
		int minutes  = 0;
		int seconds  = 0;
		double rest1 = 0;
		double rest2 = 0;
		String hour  = new String("");

		hours = (int) Math.floor(time / 3600) ;
		rest1 = ((double) time / 3600 ) - hours;

		minutes = ((int) (rest1 * 3600) / 60);
		rest2 = ((rest1 * 3600) / 60) - minutes; 

		seconds = (int) Math.round(rest2 * 60);
		
		hour  = ((hours+1 >= 10) ? ""+(hours+1) : "0" + (hours+1)) + ":"; 
		hour += ((minutes >= 10) ? ""+minutes : "0" + minutes) + ":"; 
		hour += ((seconds >= 10) ? ""+seconds : "0" + seconds);
		
		return hour;
		
	}
}
