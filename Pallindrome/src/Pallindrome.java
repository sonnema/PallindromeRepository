import java.util.Scanner;

public class Pallindrome {
	public static void main(String[] args) {

		int inputValue = 8;
		String lowestMultLmt = lowestMultiplierLimit(inputValue);
		System.out.println("lowestMultLmt--->" + lowestMultLmt);

		String highestMultLmt = highestMultiplierLimit(inputValue);
		System.out.println("highestMultLmt--->" + highestMultLmt);

		int highestMultipleDivisBy11 = highestMultipleDivisibleBy11(Integer
				.parseInt(highestMultLmt));
		// string//get minimum palindrome product limit
		String minimumProdLmt = minProductValue(inputValue);
		System.out.println("miniumum prodct--->" + minimumProdLmt);
	}

	private static String lowestMultiplierLimit(int inputdigit) {
		System.out.println("input digit--->" + inputdigit);
		String lowestOperand = new String();
		if (inputdigit % 2 != 0) {

			System.out.println("its odd number :" + inputdigit);
			for (int i = 0; i < (Math.round(inputdigit - 1) / 2); i++) {
				lowestOperand += '9';
			}
			for (int i = 0; i < (Math.round(inputdigit / 2)); i++) {
				lowestOperand += '0';
			}

			System.out.println("its odd number :" + lowestOperand);
		} else {
			for (int i = 0; i < (Math.round(inputdigit - 1) / 2); i++) {
				lowestOperand += '9';
			}
			for (int i = 0; i < (Math.round(inputdigit - 1) / 2); i++) {
				lowestOperand += '0';
			}
		}
		return lowestOperand;
	}

	private static String highestMultiplierLimit(int inputDigit) {
		String highestOperand = "9";
		for (int i = 1; i < inputDigit; i++) {
			highestOperand += '9';
		}
		return highestOperand;
	}

	private static int highestMultipleDivisibleBy11(int highestMultLimit) {
		// int i;
		int highestMultDivBy11 = 0;
		do {
			if (highestMultLimit % 11 == 0) {
				highestMultDivBy11 = highestMultLimit;
				break;
			} else {
				highestMultLimit -= 1;
			}
		} while (highestMultDivBy11 == 0);
		return highestMultDivBy11;
	}

	private static String minProductValue(int inputDigit) {
		String minimumProductValue = "";

		if (inputDigit % 2 != 0) {
			for (int i = 0; i < (Math.round(inputDigit - 1) / 2); i++) {
				minimumProductValue += '9';
			}
			for (int i = 0; i < (Math.round(3 * inputDigit / 2)); i++) {
				minimumProductValue += '0';
			}
		} else {
			for (int i = 0; i < (Math.round(inputDigit - 1) / 2); i++) {
				minimumProductValue += '9';
			}
			for (int i = 0; i < (Math.round(3 * inputDigit - 1) / 2); i++) {
				minimumProductValue += '0';
			}
		}
		return minimumProductValue;
	}

	private static int LargstPalindrmProdlt7digits(int lowestOperandLimit,
			int highestOperandLimit, int minProductLmt,
			int highestOperandDivisibleBy11) {
		// var prod = 0;
		boolean boolVal = false;
		int i = highestOperandDivisibleBy11;
		int j = highestOperandLimit;
		String product = new String();
		int lowerVal = 0;
		String iLastDigit = null, jLastDigit = null;
		int maxPalindromeProduct = minProductLmt;
		for (i = highestOperandDivisibleBy11; (i > lowestOperandLimit); i -= 11) {

			iLastDigit = Integer.toString(i).substring(
					Integer.toString(i).length() - 1, 1);

			if ((iLastDigit == "1") || (iLastDigit == "3")
					|| (iLastDigit == "7") || (iLastDigit == "9")) {
				if (i % 10 != 0) {
					for (j = highestOperandLimit; (j > lowestOperandLimit); j = j - 1) {
						if ((i * j) % 11 == 0) {
							jLastDigit = Integer.toString(j).substring(
									Integer.toString(j).length() - 1, 1);
							if ((iLastDigit == "9" && jLastDigit == "1")
									|| (iLastDigit == "3" && jLastDigit == "3")
									|| (iLastDigit == "7" && jLastDigit == "7")
									|| (iLastDigit == "1" && jLastDigit == "9")) {
								if ((i * j) > maxPalindromeProduct) {
									int prod = i * j;
									product = new Integer(prod).toString();
									boolVal = chkPalindrome(prod);
									if (boolVal == true) {
										maxPalindromeProduct = prod;
										minProductLmt = maxPalindromeProduct;
										break;
									}
								}// end of if(j%10!=0)
							}// end of if(j.substr)
						}// end of if(i*j%11) check
					}// end of for j loop
				}// end of if(i%10!==0)
			}// end of if(i.substr)
		}// end of while loop
		return maxPalindromeProduct;
	}

	static boolean chkPalindrome(int product) {
		return true;
	}

	int consoleCounter = 0, consoleCounter1 = 0;

	static int LargstPalindrmProdgt7digits(int lowestOperandLimit,
			int highestOperandLimit, int minProductLmt,
			int highestOperandDivisibleBy11) {

		int iOperand = highestOperandDivisibleBy11;
		int jOperand;
		String iOperandLastDigit = null, jOperandLastDigit = null;
		boolean booleanVal = false;
		int iMultj = 0;
		int maxPalindrmeProdHigherDigits = minProductLmt;
		for (iOperand = highestOperandDivisibleBy11; iOperand > lowestOperandLimit; iOperand -= 11) {
			iOperandLastDigit = Integer.toString(iOperand).substring(
					Integer.toString(iOperand).length() - 1, 1);
			if ((iOperandLastDigit == "1") || (iOperandLastDigit == "3")
					|| (iOperandLastDigit == "7") || (iOperandLastDigit == "9")) {
				if (iOperand % 10 != 0) {
					for (jOperand = highestOperandLimit; jOperand > Math
							.sqrt(maxPalindrmeProdHigherDigits); jOperand = jOperand - 1) {
						jOperandLastDigit = Integer
								.toString(jOperand)
								.toString()
								.substring(
										Integer.toString(jOperand).length() - 1,
										1);

						if ((iOperandLastDigit == "9" && jOperandLastDigit == "1")
								|| (iOperandLastDigit == "3" && jOperandLastDigit == "3")
								|| (iOperandLastDigit == "7" && jOperandLastDigit == "7")
								|| (iOperandLastDigit == "1" && jOperandLastDigit == "9"))
							if ((jOperand % 10 != 0)
									&& (iOperand % 11 == 0 || jOperand % 11 == 0)) {

								iMultj = multiplyLargeNumbers(iOperand,
										jOperand);
								if (compareProducts(iMultj,
										maxPalindrmeProdHigherDigits) > 0) {
									booleanVal = chkPalindrome(iMultj);
									if (booleanVal == true) {
										maxPalindrmeProdHigherDigits = iMultj;
										minProductLmt = maxPalindrmeProdHigherDigits;
										System.out
												.println("Maximum palindrome product : "
														+ maxPalindrmeProdHigherDigits
														+ " value of i and j are "
														+ iOperand
														+ " "
														+ jOperand);
										break;
									}
								}
							}
					}
				}
			}
		}
		return maxPalindrmeProdHigherDigits;
	}

	static int compareProducts(int product1, int product2) {
		return (product1 - product2);
	}

	static int multiplyLargeNumbers(int Number1i,int Number2i)
	{/*
		int result[];
		if ((Number1i | 0) == 0 || (Number2i | 0) == 0) {
	        return '0';
	    }
	    Number1i = reverseNumber(Number1i);
	    Number2i = reverseNumber(Number2i);
	    int[] Number1i = Number1i.stream(array).mapToInt(Integer::intValue).toArray();
	    int []Number2= Number2i.
	    for (var i = 0; Number1[i] >= 0; i++) {
	        for (var j = 0; Number2[j] >= 0; j++) {
	            if (!result[i + j]) {
	                result[i + j] = 0;
	            }
	           result[i + j] += Number1[i] * Number2[j];
	        }
	    }

	    for (var i = 0; result[i] >= 0; i++) {
	        if (result[i] >= 10) {
	            if (!result[i + 1]) {
	                result[i + 1] = 0;
	            }

	            result[i + 1] += parseInt(result[i] / 10);
	            result[i] %= 10;
	        }
	    }

	   // return result.reverse().join('');
	    
	*/
		return 0;}

	static private int reverseNumber(int n) {

		int reverse = 0;

		while (n != 0) {
			reverse = reverse * 10;
			reverse = reverse + n % 10;
			n = n / 10;
		}

		System.out.println("Reverse of the number is " + reverse);
		return n;
	}

}