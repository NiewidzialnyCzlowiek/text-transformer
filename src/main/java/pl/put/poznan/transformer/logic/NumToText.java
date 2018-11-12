package pl.put.poznan.transformer.logic;

public class NumToText {
	
	public static String units[] = {"jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"};
	public static String teens[] = {"jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"};
	public static String tens[] = {"dziesięć", "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt", "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąt", "dziewiędziesiąt"};
	public static String hundreds[] = {"sto", "dwieście", "trzysta", "czterysta", "pięćset", "sześcset", "siedemset", "osiemset", "dziewięćset"};
	
	public static String toText(String num) { //main method to call
		int i = num.length();
		switch(i) {
		case 1: return getUnits(num);
		case 2: return getTens(num);
		case 3: return getHundreds(num) + " " + getTens(num.substring(1));
		case 4: return getThousands(num) + " " + getHundreds(num.substring(1)) + " " + getTens(num.substring(2));
		}
		return num;
	}
	
	public static String getUnits(String num) {
		char digit = num.charAt(0);
		if (digit == '0') {
			return "zero";
		} else {
			return units[(((int)digit) - ((int)'0')) - 1];
		}
	}
	
	public static String getTeens(String num) {
		num = num.substring(0,2);
		if (num == "10")
			return "dziesięć";
		char digit = num.charAt(1);
		return teens[((int)digit - (int)'0') - 1];
	}
	
	public static String getTens(String num) {
		char digit = num.charAt(0);
		if (digit == '0' && num.charAt(1) == '0') {
			return "";
		}
		if (digit == '0') {
			return getUnits(num.substring(1,2));
		}
		if (digit == '1') {
			return getTeens(num);
		}
		return tens[((int)digit - (int)'0') - 1] + " " + getUnits(num.substring(1,2));
	}
	
	public static String getHundreds(String num) {
		char digit = num.charAt(0);
		if (digit == '0')
			return "";
		return hundreds[((int)digit - (int)'0') - 1];
	}
	
	public static String getThousands(String num) {
		char digit = num.charAt(0);
		if (digit == '0')
			return "";
		if (digit == '1') {
			return "tysiąc";
		} else {
			if (((int)digit) > ((int)'4')) {
				return getUnits(num) + " tysięcy"; 
 			} else {
 				return getUnits(num) + " tysiące";
 			}
		}
	}
	
}
