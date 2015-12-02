
public class DigitsSum {

	public static void main(String[] args) {
		System.out.println(DigitsSum.lastDigit(12345));
		System.out.println(DigitsSum.lastDigit(6));
		System.out.println(DigitsSum.lastDigit(999999999));
		System.out.println(DigitsSum.lastDigit(213413512));
		System.out.println(DigitsSum.lastDigit(314));
		System.out.println(DigitsSum.lastDigit(2147483647));
	}

	public static int lastDigit(int n) {
		do {
			String values = String.valueOf(n);
			n = 0;
			for (int x = 0; x < values.length(); x++) {
				n += Integer.valueOf(String.valueOf(values.charAt(x)));
			}
		} while (n > 9);
		return n;
	}
}
