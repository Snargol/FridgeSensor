

public class Random {
	public static int alea(int min, int max) {
		return (min + (int) Math.round(Math.random() * ((max - min) + 1)));
	}
	
	public static int alea( int max) {
		return  (int) Math.round(Math.random() * max);
	}
}
