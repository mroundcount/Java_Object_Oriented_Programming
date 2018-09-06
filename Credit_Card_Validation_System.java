//Michael Roundcount

//valid numbers: 4388576018410707
//invalid numbers: 4246345689049834

import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter credit a card number: ");
		long n = input.nextLong();

		// Calling the method
		if (isValid(n)) {
			System.out.println("The number is valid.");
		} else {
			System.out.println("The number is invalid.");
		}

	}

	// use the boolean because it is either valid or not
	public static boolean isValid(long n) {

		// Are the two values divisible by exactly 10?
		// Use the % as it will not have a remainder:
		if (((addOdd(n) + addEven(n)) % 10 == 0)

				// and the long has to be between 13 and 16 characters
				&& (getSize(n) <= 16 && getSize(n) >= 13) &&

				// using || for the "or" to cover the first digit(s) of the card
				(firstMatched(n, 4) || firstMatched(n, 5) || firstMatched(n, 37) || firstMatched(n, 6)))
			return true;
		else
			return false;
	}

	// 1. Double every second digit from right to left.
	public static int addEven(long n) {
		// start with the second digit from the right
		int numDigits = getSize(n) - 1;
		int sum = 0;
		n /= 10;
		for (int i = 0; i < numDigits; i += 2) {
			sum += getDigit((int) (2 * (n % 10)));
			n /= 100;
		}
		return sum;
	}

	// If doubling of a digit results in a two-digit number,
	// add up the two digits to get a single-digit number.
	public static int getDigit(int number) {
		if (number < 9)
			return number;
		else
			return number / 10 + number % 10;
	}

	// 3. Add all digits in the odd places from right to left in the card number.
	public static int addOdd(long n) {
		int sum = 0;
		String num = n + "";
		for (int i = getSize(n) - 1; i >= 0; i -= 2) {
			sum += Integer.parseInt(num.charAt(i) + "");
		}

		return sum;
	}

	// change prefix
	public static boolean firstMatched(long number, int d) {
		if (getFirst(number, getSize(d)) == d)
			return true;
		else
			return false;
	}

	// count the number of digits
	public static int getSize(long d) {
		String num = d + "";
		return num.length();
	}

	// Find the first number or numbers to use to check the first digits.
	public static long getFirst(long number, int k) {
		int numberDigits = getSize(number);
		if (numberDigits - k > 0) {
			for (int i = 0; i < numberDigits - k; i++) {
				number /= 10;
			}
			return number;
		} else
			return number;
	}
}
