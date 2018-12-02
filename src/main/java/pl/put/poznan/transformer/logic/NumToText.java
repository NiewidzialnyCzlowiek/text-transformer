package pl.put.poznan.transformer.logic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
class NumToText {

	static String units[] = {"jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"};
	static String teens[] = {"jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"};
	static String tens[] = {"dziesięć", "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt", "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąt", "dziewiędziesiąt"};
	static String hundreds[] = {"sto", "dwieście", "trzysta", "czterysta", "pięćset", "sześcset", "siedemset", "osiemset", "dziewięćset"};

	/**
	 * Returns string with numbers changed to words
	 * @param text string to be expanded with numbers
	 * @return transformed string
	 */
	static String toText(String text) {
		List<String> words = Arrays.asList(text.split("\\s"));
		List<String> trans = new ArrayList<String>();
		for( int i = 0; i< words.size(); i++){
			trans.add(getStrNum(words.get(i)));
		}
		text = String.join(" ", trans);
		log.debug(String.format("Num to text done, result: %s", text));
		return text;
	}

	public static String getStrNum(String num) {
		if(!num.chars().allMatch(Character::isDigit)) {
			return num;
		}
		log.debug("Num to text invoked");
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
