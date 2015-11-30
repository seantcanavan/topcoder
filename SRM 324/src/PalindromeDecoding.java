
public class PalindromeDecoding {

	public static void main(String[] args) {
		System.out.println(PalindromeDecoding.decode("ab", new int[] { 0 }, new int[] { 2 }));
		System.out.println(PalindromeDecoding.decode("Misip", new int[] { 2, 3, 1, 7 }, new int[] { 1, 1, 2, 2 }));
		System.out.println(PalindromeDecoding.decode("XY", new int[] { 0, 0, 0, 0 }, new int[] { 2, 4, 8, 16 }));
		System.out.println(PalindromeDecoding.decode("TC206", new int[] { 1, 2, 5 }, new int[] { 1, 1, 1 }));
		System.out.println(PalindromeDecoding.decode("nodecoding", new int[] {}, new int[] {}));
	}

	public static String decode(String code, int[] position, int[] length) {
		String decoded = code;

		for (int x = 0; x < length.length; x++) {
			int currentPosition = position[x];
			int currentLength = length[x];
			StringBuilder toAppend = new StringBuilder();
			for (int y = currentLength - 1; y >= 0; y--) {
				toAppend.append(decoded.charAt(y + currentPosition));
			}
			// stitch the string back together
			decoded = decoded.substring(0, currentPosition + currentLength) + toAppend.toString()
					+ decoded.substring(currentPosition + currentLength, decoded.length());
		}

		return decoded;
	}
}
