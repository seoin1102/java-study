package prob03;

public class CurrencyConverter {
	
	private static double rate;
	
	public static void setRate(double rate) {
		CurrencyConverter.rate = rate;
	}

	public static double toDollar(double d) {
		double dollar = d / CurrencyConverter.rate;
		return dollar;
	}

	public static double toKRW(double d) {
		double KRW = d * CurrencyConverter.rate;
		return KRW;
	}

	public static double toDollar(int i) {
		
		return 0;
	}

	public static double toKRW(double d) {
		// TODO Auto-generated method stub
		return 0;
	}

}
