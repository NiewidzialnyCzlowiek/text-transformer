package pl.put.poznan.transformer.logic;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
class NumToTextDecorator extends TransformerDecorator {

	private String units[] = {"jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"};
	private String teens[] = {"jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"};
	private String tens[] = {"dziesięć", "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt", "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąt", "dziewiędziesiąt"};
	private String hundreds[] = {"sto", "dwieście", "trzysta", "czterysta", "pięćset", "sześcset", "siedemset", "osiemset", "dziewięćset"};


	public NumToTextDecorator(Transformer transformer) {
		super(transformer);
	}

	/**
	 * Returns string with numbers changed to words
	 * @param num string to be expanded with numbers
	 * @return transformed string
	 */
	public String transform(String num) {
	  	num = transformer.transform(num);
		log.debug("Num to text invoked");
		List<String> chunks = Stream.of(num.trim().split("\\s"))
				.map(this::transformChunk)
				.collect(Collectors.toList());
		num = String.join(" ", chunks);
		log.debug(String.format("Num to text done, result: %s", num));
		return num;
	}

	String transformChunk(String num) {
		if(!num.chars().allMatch(Character::isDigit)) {
			return num;
		}
		int i = num.length();
		switch(i) {
			case 1: return getUnits(num);
			case 2: return getTens(num);
			case 3: return getHundreds(num) + " " + getTens(num.substring(1));
			case 4: return getThousands(num) + " " + getHundreds(num.substring(1)) + " " + getTens(num.substring(2));
		}
		return num;
	}

	String getUnits(String num) {
		char digit = num.charAt(0);
		if (digit == '0') {
			return "zero";
		} else {
			return units[(((int)digit) - ((int)'0')) - 1];
		}
	}
	
	String getTeens(String num) {
		num = num.substring(0,2);
		if (num.equals("10"))
			return "dziesięć";
		char digit = num.charAt(1);
		return teens[((int)digit - (int)'0') - 1];
	}
	
	String getTens(String num) {
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
	
	String getHundreds(String num) {
		char digit = num.charAt(0);
		if (digit == '0')
			return "";
		return hundreds[((int)digit - (int)'0') - 1];
	}
	
	String getThousands(String num) {
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
