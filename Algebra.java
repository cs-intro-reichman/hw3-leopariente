// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(-1, -3)); // -1 -3
		System.out.println(minus(7, 2)); // 7 - 2
		System.out.println(minus(2, 7)); // 2 - 7
		System.out.println(times(3, 4)); // 3 * 4
		System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		System.out.println(pow(5, 3)); // 5^3
		System.out.println(pow(3, 5)); // 3^5
		System.out.println(div(12, 3)); // 12 / 3
		System.out.println(div(5, 5)); // 5 / 5
		System.out.println(div(25, 7)); // 25 / 7
		System.out.println(mod(25, 7)); // 25 % 7
		System.out.println(mod(120, 6)); // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				sum++;
			}
		} else {
			for (int i = 0; i > x2; i--) {
				sum--;
			}
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int difference = x1;
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				difference--;
			}
		} else {
			for (int i = 0; i > x2; i--) {
				difference++;
			}
		}
		return difference;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int result = 0;
		if (x1 > 0 && x2 > 0) {
			if (x1 > 0 && x2 > 0) {
				for (int i = 0; i < x2; i++) {
					result = plus(result, x1);
				}
			}
		} else if (x1 < 0 && x2 < 0) {
			for (int i = 0; i > x2; i--) {
				result = minus(result, x1);
			}
		} else {
			int counter = x2 < x1 ? x2 : x1;
			int numberToMultiply = counter == x2 ? x1 : x2;
			for (int i = 0; i > counter; i--) {
				result = minus(result, numberToMultiply);
			}
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result = 1;
		for (int i = 0; i < n; i++) {
			result = times(result, x);
		}
		return result;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		int result = 0;
		int sign = -1;
		int dividend = Math.abs(x1);
		int divisor = Math.abs(x2);
		while (dividend >= Math.abs(divisor)) {
			dividend = minus(dividend, divisor);
			result++;
			if ((x1 > 0 && x2 > 0) || (x1 < 0 && x2 < 0))
				sign = 1;
		}
		return times(result, sign);
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int division = div(x1, x2);
		int res = times(division, x2);
		return x1 - res;
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		if (x == 0) return 0;
		int result = 1;
		while (pow(result, 2) < x) {
			if (pow(plus(result, 1), 2) > x)
				return result;
			result = plus(result, 1);
		}
		return result;
	}
}