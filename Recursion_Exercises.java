
public class Recursion_Exercises {

	public static void main(String[] args) {

		System.out.println("factorial:" + factorial(3));
		System.out.println("taylor:" + taylor(1, 20));

		System.out.println("q2:" + q2(1.0, 20));

		System.out.println("sumDigitsOneDigit:");
		int x1 = 19, x2 = 7, x3 = 88, x4 = 578976;
		System.out.print(" x1=" + x1 + "-->" + sumDigitsOneDigit(x1));
		System.out.print(", x2=" + x2 + "-->" + sumDigitsOneDigit(x2));
		System.out.print(", x3=" + x3 + "-->" + sumDigitsOneDigit(x3));
		System.out.print(", x4=" + x4 + "-->" + sumDigitsOneDigit(x4));

		System.out.println("\n" + "binayToDecimal:" + binaryToDecimal("1111"));
		System.out.println("decimalToBinary:" + decimalToBinary(10));
		System.out.println("decimalToBinarySB:" + decimalToBinarySB(10));

		System.out.println("Q5:" + Q5(4));

		System.out.println("Q6:" + Q6("abcccccac", 'd'));

		System.out.println("Q7_a:" + Q7_a("AS9abc123Zazx4578#a6"));
		System.out.println("Q7_b:" + Q7_b("AS9abc123Zazx4578#A6"));
		System.out.println("Q7_c:" + Q7_c("AS9abc123Zazx4578#6"));
	}

	private static long factorial(int n) {
		if (n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}

	// Q1
	private static double taylor(double x, int n) {
		if (n == 0)
			return 1;
		else
			return Math.pow(x, n) / factorial(n) + taylor(x, n - 1);
	}

	// Q2
	private static double q2(double x, int n) {
		if (n == 0)
			return x;
		else
			return Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / factorial(2 * n + 1) + taylor(x, n - 1);
	}

	// Q3
	private static int sumDigitsOneDigit(int n) {
		if (n < 10)
			return n;
		else
			return sumDigitsOneDigit(n / 10 + n % 10);
	}

	// Q4_a
	private static int binaryToDecimal(String str) {
		if (str.length() == 0 || str == null)
			return 0;
		else
			return (str.charAt(0) - '0') * (int) Math.pow(2, str.length() - 1) + binaryToDecimal(str.substring(1));
	}

	// Q4_b
	// elegant
	private static String decimalToBinary(int n) {
		if (n == 0)
			return "";
		return decimalToBinary(n / 2) + n % 2;
	}

	// *** Solution with String ***
	private static String decimalToBinary2(int n) {
		String str = "";
		str = decimalToBinary2(n, str);
		String reverse = new StringBuilder(str).reverse().toString();
		return reverse;
	}

	private static String decimalToBinary2(int n, String str) {
		if (n == 0)
			return str;
		if (n % 2 == 0)
			return str.concat("0" + decimalToBinary2(n / 2, str));
		else
			return str.concat("1" + decimalToBinary2(n / 2, str));
	}
	// *** end ***

	// *** Solution with StringBuilder ***
	private static String decimalToBinarySB(int n) {
		StringBuilder sb = new StringBuilder("");
		return decimalToBinarySB(n, sb).reverse().toString();
	}

	private static StringBuilder decimalToBinarySB(int n, StringBuilder sb) {
		if (n == 0)
			return sb;
		if (n % 2 == 0) {
			sb.append("0");
			return decimalToBinarySB(n / 2, sb);
		} else {
			sb.append("1");
			return decimalToBinarySB(n / 2, sb);
		}
	}
	// *** end ***

	// Q5
	private static double Q5(int i) {
		if (i == 1)
			return 1;
		else
			return (1.0 / i) + Q5(i - 1);
	}

	// Q6
	private static int Q6(String str, char c) {
		if (str.length() == 0 || str == null) {
			return 0;
		} else if (str.charAt(0) == c) {
			return 1 + Q6(str.substring(1), c);
		} else {
			return Q6(str.substring(1), c);
		}
	}

	// Q7
	// a
	private static int Q7_a(String str) {
		if (str.length() == 0 || str == null)
			return 0;
		else if (str.charAt(0) >= 'a' && str.charAt(0) <= 'z')
			return 1 + Q7_a(str.substring(1));
		else
			return Q7_a(str.substring(1));
	}

	// b
	private static int Q7_b(String str) {
		if (str.length() == 0 || str == null)
			return 0;
		else if (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z')
			return 1 + Q7_b(str.substring(1));
		else
			return Q7_b(str.substring(1));
	}

	// c
	private static int Q7_c(String str) {
		if (str.length() == 0 || str == null)
			return 0;
		if (Character.isDigit(str.charAt(0)))
			return 1 + Q7_c(str.substring(1));
		else
			return Q7_c(str.substring(1));
	}

	// d
	private static void Q7(String str, char mode) {
		mode = Character.toLowerCase(mode);
		switch (mode) {
		case 'a':
			Q7_a(str);
		case 'b':
			Q7_b(str);
		case 'c':
			Q7_b(str);
		}
	}
}
